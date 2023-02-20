package tn.esprit.marketplace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.marketplace.entities.AttachementProduct;

@Repository
public interface AttachementRepository extends JpaRepository<AttachementProduct,Long> {
}
