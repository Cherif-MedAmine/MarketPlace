package tn.esprit.marketplace.services;

import tn.esprit.marketplace.entities.Product;

public interface IProductServices {

    Product addProduct(Product product);

    Product addProductToBasket(Long idProduct, Long idUser);

    Product likeProduct(Long idProduct);

    Product likeProduct2(Long idProduct);

    Product addProductToFavoris(Long idProduct, Long idUser);

    Product updateProduct(Product product);

    void deleteProduct(Product product);

    void deleteProductById(Long idProduct);
}
