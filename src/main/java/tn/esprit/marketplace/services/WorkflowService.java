package tn.esprit.marketplace.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.marketplace.entities.*;
import tn.esprit.marketplace.exception.GenericException;
import tn.esprit.marketplace.repositories.*;
import tn.esprit.marketplace.services.interfaces.IWorkflowService;
import tn.esprit.marketplace.utils.ConstUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WorkflowService implements IWorkflowService {

    WorkflowRepository workflowRepository;
    TransactionRepository transactionRepository;
    BasketRepository basketRepository;
    ProductBasketRepository productBasketRepository;
    ProductRepository productRepository;
    StoreRepository storeRepository;

    @Override
    public void addWorkflow(Long idBasket) {
        Basket basket = basketRepository.findById(idBasket)
                .orElseThrow(() -> new RuntimeException(String.format(ConstUtils.BASKET_NOT_EXIST)));
        Transaction transaction = transactionRepository.getTransactionByBasket(basket);
        List<ProductBasket> productBaskets = productBasketRepository.getProductBasketsByBasket(basket);
        List<Workflow> workflows = productBaskets.stream()
                .map(productBasket -> {
                    Product product = productRepository.getProductByProductBaskets(productBasket);
                    Workflow workflow = new Workflow();
                    workflow.setTransaction(transaction);
                    workflow.setTransactionDate(transaction.getTransaction_date());
                    workflow.setTotalAmount(transaction.getTotal_amount());
                    workflow.setProductId(product.getIdProduct());
                    workflow.setProductQuantity(productBasket.getQnt());
                    workflow.setProductName(product.getNameProduct());
                    workflow.setProductPrice(product.getPriceAfterSales());
                    workflow.setSeller(product.getStore().getNameStore());
                    workflow.setBuyer(transaction.getUsername());
                    return workflow;
                })
                .collect(Collectors.toList());
        workflowRepository.saveAll(workflows);
    }

    @Override
    public List<Workflow> getAllWorkflows() {
        List<Workflow> workflows = workflowRepository.findAll();
        if (workflows == null) throw new GenericException(ConstUtils.WORKFLOW_NOT_EXIST);
        return workflows;
    }

    @Override
    public List<Workflow> getWorkflowsByStoreId(Long idStore) {
        Store store = storeRepository.findById(idStore).get();
        List<Workflow> workflows = workflowRepository.getWorkflowsBySeller(store.getNameStore());
        if (workflows == null) throw new GenericException(ConstUtils.WORKFLOW_NOT_EXIST);
        return workflows;
    }

    @Override
    public List<Workflow> getWorkflowsByDateBetween(Long idStore, Date startDate, Date endDate) {
        Store store = storeRepository.findById(idStore).orElseThrow(() -> new GenericException(ConstUtils.STORE_NOT_EXIST));
        List<Workflow> workflows = workflowRepository.getWorkflowsBySeller(store.getNameStore());
        if (workflows == null) throw new GenericException(ConstUtils.WORKFLOW_NOT_EXIST);

        List<Workflow> filteredWorkflows = new ArrayList<>();
        for (Workflow workflow : workflows) {
            if (workflow.getTransactionDate().after(startDate) && workflow.getTransactionDate().before(endDate)) {
                filteredWorkflows.add(workflow);
            }
        }

        return filteredWorkflows;
    }

    @Override
    public float getIncomeBySeller(Long idStore) {
        Store store = storeRepository.findById(idStore).get();
        float income = 0.0f;
        income = workflowRepository.sumProductPriceBySeller(store.getNameStore());
        return income;
    }

    @Override
    public float getIncomeByDate(Long idStore, Date date) {
        Store store = storeRepository.findById(idStore).orElseThrow(() -> new GenericException(ConstUtils.STORE_NOT_EXIST));
        List<Workflow> workflows = workflowRepository.getWorkflowsBySellerAndTransactionDateLike(store.getNameStore(), date);
        if (workflows == null || workflows.isEmpty()) {
            return 0.0f;
        }

        Set<Long> transactionIds = new HashSet<>();
        float income = 0.0f;
        for (Workflow workflow : workflows) {
            income += workflow.getProductPrice();
        }
        return income;
    }


}
