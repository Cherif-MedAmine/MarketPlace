package tn.esprit.marketplace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.marketplace.entities.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
   List<Product>  getProductsByCategoryProduct_NameCategoryP(String categoryName);

   ////

   @Query("SELECT p FROM Product p WHERE p.store.idStore = :storeId")
   List<Product> findProductsByStoreId(@Param("storeId") Long idStore);

}
