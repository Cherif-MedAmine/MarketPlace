package tn.esprit.marketplace.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.marketplace.entities.*;
import tn.esprit.marketplace.exception.GenericException;
import tn.esprit.marketplace.repositories.*;
import tn.esprit.marketplace.services.interfaces.IHistoryService;
import tn.esprit.marketplace.utils.ConstUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HistoryService implements IHistoryService {

    HistoryRepository historyRepository;
    TransactionRepository transactionRepository;
    BasketRepository basketRepository;
    ProductBasketRepository productBasketRepository;
    ProductRepository productRepository;
    StoreRepository storeRepository;
    CategoryProductRepository categoryProductRepository;

    @Override
    public void addHistory(Long idBasket) {
        Basket basket = basketRepository.findById(idBasket)
                .orElseThrow(() -> new RuntimeException(String.format(ConstUtils.BASKET_NOT_EXIST)));
        Transaction transaction = transactionRepository.getTransactionByBasket(basket);
        List<ProductBasket> productBaskets = productBasketRepository.getProductBasketsByBasket(basket);
        List<History> histories = productBaskets.stream()
                .map(productBasket -> {
                    Product product = productRepository.getProductByProductBaskets(productBasket);
                    History history = new History();
                    history.setTransaction(transaction);
                    history.setTransactionDate(transaction.getTransaction_date());
                    history.setTotalAmount(transaction.getTotal_amount());
                    history.setProductId(product.getIdProduct());
                    history.setProductQuantity(productBasket.getQnt());
                    history.setProductName(product.getNameProduct());
                    history.setProductPrice(product.getPriceAfterSales());
                    history.setProductCategory(product.getCategoryProduct().getNameCategoryP());
                    history.setSeller(product.getStore().getNameStore());
                    history.setBuyer(transaction.getUsername());
                    return history;
                })
                .collect(Collectors.toList());
        historyRepository.saveAll(histories);
    }

    @Override
    public List<History> getAllHistories() {
        List<History> histories = historyRepository.findAll();
        if (histories == null) throw new GenericException(ConstUtils.HISTORY_NOT_EXIST);
        return histories;
    }

    @Override
    public List<History> getHistoriesBySeller(Long idStore) {
        Store store = storeRepository.findById(idStore).orElseThrow(() -> new GenericException(ConstUtils.STORE_NOT_EXIST));
        List<History> histories = historyRepository.getHistoriesBySeller(store.getNameStore());
        if (histories == null) throw new GenericException(ConstUtils.HISTORY_NOT_EXIST);
        return histories;
    }

    @Override
    public List<History> getHistoriesBySellerDateBetween(Long idStore, Date startDate, Date endDate) {
        Store store = storeRepository.findById(idStore).orElseThrow(() -> new GenericException(ConstUtils.STORE_NOT_EXIST));
        List<History> histories = historyRepository.getHistoriesBySeller(store.getNameStore());
        if (histories == null) throw new GenericException(ConstUtils.HISTORY_NOT_EXIST);

        List<History> filteredHistories = new ArrayList<>();
        for (History history : histories) {
            if (history.getTransactionDate().after(startDate) && history.getTransactionDate().before(endDate)) {
                filteredHistories.add(history);
            }
        }

        return filteredHistories;
    }

    @Override
    public float getIncomeBySeller(Long idStore) {
        Store store = storeRepository.findById(idStore).orElseThrow(() -> new GenericException(ConstUtils.STORE_NOT_EXIST));
        float income = 0.0f;
        income = historyRepository.sumProductPriceBySeller(store.getNameStore());
        return income;
    }

    @Override
    public float getIncomeByDateBetween(Long idStore, Date startDate, Date endDate) {
        Store store = storeRepository.findById(idStore).orElseThrow(() -> new GenericException(ConstUtils.STORE_NOT_EXIST));
        List<History> histories = historyRepository.getHistoriesBySeller(store.getNameStore());
        if (histories == null) return 0.0f;

        float income = 0.0f;
        for (History history : histories) {
            if (history.getTransactionDate().after(startDate) && history.getTransactionDate().before(endDate)) {
                income += history.getProductPrice();
            }
        }

        return income;
    }

    @Override
    public List<History> getHistoriesByCategory(Long idCategory) {
        CategoryProduct categoryProduct = categoryProductRepository.findById(idCategory).get();
        List<History> histories = historyRepository.getHistoriesByProductCategory(categoryProduct.getNameCategoryP());
        if (histories == null) throw new GenericException(ConstUtils.HISTORY_NOT_EXIST);
        return histories;
    }

    @Override
    public List<History> getHistoriesByCategoryDateBetween(Long idCategory, Date startDate, Date endDate) {
        CategoryProduct categoryProduct = categoryProductRepository.findById(idCategory).get();
        List<History> histories = historyRepository.getHistoriesByProductCategory(categoryProduct.getNameCategoryP());
        if (histories == null) throw new GenericException(ConstUtils.HISTORY_NOT_EXIST);

        List<History> filteredHistories = new ArrayList<>();
        for (History history : histories) {
            if (history.getTransactionDate().after(startDate) && history.getTransactionDate().before(endDate)) {
                filteredHistories.add(history);
            }
        }

        return filteredHistories;
    }

}
