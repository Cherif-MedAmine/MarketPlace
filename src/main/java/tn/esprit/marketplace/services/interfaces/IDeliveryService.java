package tn.esprit.marketplace.services.interfaces;



import tn.esprit.marketplace.entities.Delivery;

import java.util.List;

public interface IDeliveryService {

    Delivery addDelivery(Delivery delivery);

    Delivery updateDeliveryById(Long IdDelivery, Delivery delivery);

    void deleteDeliveryById(Long IdDelivery);

    public List<Delivery> getListDelivery();

    public Delivery addDeliveryAndAssignToTransaction(Long transactionId, Delivery delivery);



}
