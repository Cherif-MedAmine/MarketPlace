package tn.esprit.marketplace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.marketplace.entities.Basket;
import tn.esprit.marketplace.entities.ProductBasket;

import java.util.List;


@Repository
public interface ProductBasketRepository extends JpaRepository<ProductBasket,Long> {

    ProductBasket getProductBasketByProduct_IdProduct(Long productId);

    List<ProductBasket> getProductBasketsByBasket(Basket basket);
}
