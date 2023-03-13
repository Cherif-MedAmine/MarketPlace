package tn.esprit.marketplace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.marketplace.entities.CreditCard;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard,Long> {
}
