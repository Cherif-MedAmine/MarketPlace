package tn.esprit.marketplace.services.interfaces;

import tn.esprit.marketplace.entities.ProductBasket;

public interface IProductBasketService {
    void addProductToBasket(Long idProduct, Long idUser);


    void incrementQuantity(Long id);

    void decrementQuantity(Long id);

    void deleteProductFromBasket(Long id);

    float priceBasket(Long idUser, String coupon);

    int nbProductOfBasket(Long idUser);
}
