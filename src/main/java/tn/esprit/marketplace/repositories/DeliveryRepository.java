package tn.esprit.marketplace.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.marketplace.entities.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery,Long> {
    // List<Delivery> findByDeliveryType(DeliveryType deliveryType);
}
