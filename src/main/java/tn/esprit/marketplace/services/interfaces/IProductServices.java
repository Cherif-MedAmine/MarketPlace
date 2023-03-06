package tn.esprit.marketplace.services.interfaces;

import tn.esprit.marketplace.entities.Product;

import java.util.List;

public interface IProductServices {

    Product addProduct(Product product);


    Product likeProduct(Long idProduct);

    Product likeProduct2(Long idProduct);

    Product addProductToFavorite(Long idProduct, Long idUser);

    Product updateProduct(Product product);

    void deleteProductById(Long idProduct);

    Product addCategoryToProduct(Long idProduct, Long idCategory);

    List<Product> getAllProduct();

    List<Product> getProductByCategory(String categoryName);


}
