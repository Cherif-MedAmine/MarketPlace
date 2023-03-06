package tn.esprit.marketplace.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.marketplace.entities.CategoryProduct;
import tn.esprit.marketplace.entities.Product;
import tn.esprit.marketplace.repositories.CategoryProductRepository;
import tn.esprit.marketplace.repositories.ProductRepository;
import tn.esprit.marketplace.services.interfaces.ICategoryProductService;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryProductService implements ICategoryProductService {

    CategoryProductRepository categoryProductRepository;
    ProductRepository productRepository;

    @Override
    public CategoryProduct addCategoryProduct(CategoryProduct categoryProduct){

        return categoryProductRepository.save(categoryProduct);
    }
    @Override
    public  CategoryProduct updateCategoryProduct(CategoryProduct categoryProduct){

        return categoryProductRepository.save(categoryProduct);
    }
    @Override
    public void deleteCategoryProduct(Long idCategory){
        CategoryProduct c=categoryProductRepository.findById(idCategory).get();
        categoryProductRepository.delete(c);
    }

    @Override
    public List<CategoryProduct> getAllCategoryProducts() {

        return categoryProductRepository.findAll();
    }




}
