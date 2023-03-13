package tn.esprit.marketplace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.marketplace.entities.FAQ;

@Repository
public interface FAQRepository extends JpaRepository<FAQ, Long> {
    FAQ findByQuestionIgnoreCase(String question);
}
