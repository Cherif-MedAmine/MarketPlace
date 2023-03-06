package tn.esprit.marketplace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.marketplace.entities.ProductBasket;


@Repository
public interface ProductBasketRepository extends JpaRepository<ProductBasket,Long> {

    ProductBasket getProductBasketByProduct_IdProduct(Long productId);
}
