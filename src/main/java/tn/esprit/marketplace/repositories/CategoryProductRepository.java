package tn.esprit.marketplace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.marketplace.entities.CategoryProduct;

@Repository
public interface CategoryProductRepository extends JpaRepository<CategoryProduct,Long> {
}
