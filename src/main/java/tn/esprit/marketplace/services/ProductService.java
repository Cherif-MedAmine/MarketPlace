package tn.esprit.marketplace.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.marketplace.entities.Basket;
import tn.esprit.marketplace.entities.Favoris;
import tn.esprit.marketplace.entities.Product;
import tn.esprit.marketplace.entities.User;
import tn.esprit.marketplace.repositories.*;

@Service
public class ProductService implements IProductServices{
    @Autowired
    UserRepository userRepository;
    @Autowired
    AttachementRepository attachementRepository;
    @Autowired
    FavorisReopository favorisReopository;
    @Autowired
    BasketRepository basketRepository;
    @Autowired
    ProductRepository productRepo;
    @Autowired
    UserRepository userRepo;

    @Override
    public Product addProduct(Product product){

        return productRepo.save(product);
    }
    @Override
    public Product addProductToBasket(Long idProduct, Long idUser){
        Product p=productRepo.findById(idProduct).get();
        User u=userRepo.findById(idUser).get();
        Basket b=u.getBasketU();
        p.getPbaskets().add(b);

        return productRepo.save(p);
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
   public Product addProductToFavoris(Long idProduct, Long idUser){
       Product p=productRepo.findById(idProduct).get();
        User u=userRepo.findById(idUser).get();
        Favoris f=u.getFavorisU();
        p.getPfavoris().add(f);
        return productRepo.save(p);
    }
    @Override
    public Product updateProduct(Product product){

        return productRepo.save(product);
    }
    @Override
    public void deleteProduct(Product product){
         productRepo.delete(product);
    }
    @Override
    public void deleteProductById(Long idProduct){
        productRepo.deleteById(idProduct);
    }
}
