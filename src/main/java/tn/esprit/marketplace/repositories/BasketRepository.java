package tn.esprit.marketplace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.marketplace.entities.Basket;

@Repository
public interface BasketRepository extends JpaRepository<Basket,Long> {
}
