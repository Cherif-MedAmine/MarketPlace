package tn.esprit.marketplace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.marketplace.entities.CategoryStore;

@Repository
public interface CategoryStoreRepository extends JpaRepository<CategoryStore, Long> {

    CategoryStore getByNameCategoryStore(String name);
}
