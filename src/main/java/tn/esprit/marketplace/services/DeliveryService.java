package tn.esprit.marketplace.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.marketplace.entities.Delivery;
import tn.esprit.marketplace.entities.Transaction;
import tn.esprit.marketplace.repositories.DeliveryRepository;
import tn.esprit.marketplace.repositories.TransactionRepository;
import tn.esprit.marketplace.services.interfaces.IDeliveryService;


import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeliveryService implements IDeliveryService {

    @Autowired
    DeliveryRepository deliveryRepository;
    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Delivery addDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    @Override
    public Delivery updateDeliveryById(Long idDelivery, Delivery delivery) {
        Delivery delivery1 = deliveryRepository.findById(idDelivery).get();
        delivery1.setNameDelivery(delivery.getNameDelivery());
        delivery1.setAddress(delivery.getAddress());
        delivery1.setStartDate(delivery.getStartDate());
        delivery1.setStartDate(delivery.getStartDate());
        delivery1.setEndDate(delivery.getEndDate());
        return deliveryRepository.save(delivery1);
    }

    @Override
    public void deleteDeliveryById(Long idDelivery) {
        Delivery delivery = deliveryRepository.findById(idDelivery).get();
        deliveryRepository.delete(delivery);

    }

    @Override
    public List<Delivery> getListDelivery() {
        List<Delivery> deliveries = new ArrayList<>();
        deliveryRepository.findAll().forEach(deliveries::add);
        return deliveries;
    }

    @Override
    public Delivery addDeliveryAndAssignToTransaction(Long transactionId, Delivery delivery) {

            Transaction transaction = transactionRepository.findById(transactionId).orElseThrow(() ->
                    new EntityNotFoundException("Transaction with id " + transactionId + " not found"));

            delivery = deliveryRepository.save(delivery);

            transaction.setDelivery(delivery);
            transactionRepository.save(transaction);

        return delivery;
    }




}
