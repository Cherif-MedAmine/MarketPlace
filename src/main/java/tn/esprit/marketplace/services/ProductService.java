package tn.esprit.marketplace.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.marketplace.entities.CategoryProduct;
import tn.esprit.marketplace.entities.Favorite;
import tn.esprit.marketplace.entities.Product;
import tn.esprit.marketplace.entities.User;
import tn.esprit.marketplace.repositories.*;
import tn.esprit.marketplace.services.interfaces.IProductServices;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductService implements IProductServices {

    UserRepository userRepository;

    FavoriteReopository favoriteReopository;

    BasketRepository basketRepository;
    CategoryProductRepository categoryProductRepository;
    ProductRepository productRepo;

    UserRepository userRepo;

    @Override
    public Product addProduct(Product product){

        return productRepo.save(product);
    }

    @Override
    public Product likeProduct(Long idProduct){
        Product p=productRepo.findById(idProduct).get();
        int likes=p.getLikes();
        p.setLikes(likes+1);

        return productRepo.save(p);
    }
    @Override
    public Product likeProduct2(Long idProduct){
        Product p=productRepo.findById(idProduct).get();
        int likes=p.getLikes();
        p.setLikes(likes-1);

        return productRepo.save(p);
    }
    @Override
   public Product addProductToFavorite(Long idProduct, Long idUser){
       Product p=productRepo.findById(idProduct).get();
        User u=userRepo.findById(idUser).get();
         Favorite f=u.getFavoriteU();
        p.getPfavorite().add(f);
        return productRepo.save(p);
    }
    @Override
    public Product updateProduct(Product product){

        return productRepo.save(product);
    }

    @Override
    public void deleteProductById(Long idProduct){
        productRepo.deleteById(idProduct);
    }
    @Override
    public  Product addCategoryToProduct(Long idProduct, Long idCategory){
        Product p=productRepo.findById(idProduct).get();
        CategoryProduct c=categoryProductRepository.findById(idCategory).get();
        p.setCategoryProduct(c);
        return productRepo.save(p);
    }
    @Override
    public List<Product> getAllProduct(){

        return productRepo.findAll();
    }
    @Override
    public List<Product> getProductByCategory(String categoryName){

        return productRepo.getProductsByCategoryProduct_NameCategoryP(categoryName);
    }



}
