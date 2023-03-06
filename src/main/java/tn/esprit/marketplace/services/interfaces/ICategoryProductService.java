package tn.esprit.marketplace.services.interfaces;

import tn.esprit.marketplace.entities.CategoryProduct;

import java.util.List;

public interface ICategoryProductService {
    CategoryProduct addCategoryProduct(CategoryProduct categoryProduct);

    CategoryProduct updateCategoryProduct(CategoryProduct categoryProduct);

    void deleteCategoryProduct(Long idCategory);

    List<CategoryProduct> getAllCategoryProducts();
}
