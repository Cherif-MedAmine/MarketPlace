package tn.esprit.marketplace.services;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.marketplace.entities.*;
import tn.esprit.marketplace.repositories.*;
import tn.esprit.marketplace.services.interfaces.IProductBasketService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
public class ProductBasketService implements IProductBasketService {
    ProductBasketRepository productBasketRepository;
    ProductRepository productRepository;

    BasketRepository basketRepository;
    UserRepository userRepository;
    CouponRepository couponRepository;


    @Override
    public void addProductToBasket(Long idProduct, Long idUser) {
        Product p = productRepository.findById(idProduct).get();
        User u = userRepository.findById(idUser).get();
        Basket b = u.getBasketU();
        ProductBasket productBasket = productBasketRepository.getProductBasketByProduct_IdProduct(idProduct);
        if (productBasket != null){
            productBasket.setQnt(productBasket.getQnt() + 1);
            productBasketRepository.save(productBasket);
        }else {
            ProductBasket pb = new ProductBasket();
            pb.setProduct(p);
            pb.setBasket(b);
            pb.setQnt(1);
            productBasketRepository.save(pb);
        }
    }

    @Override
    public void incrementQuantity(Long id) {
        ProductBasket pb = productBasketRepository.findById(id).get();
        pb.setQnt(pb.getQnt() + 1);
        productBasketRepository.save(pb);
    }

    @Override
    public void decrementQuantity(Long id) {
        ProductBasket pb = productBasketRepository.findById(id).get();
        if (pb.getQnt() > 1) {
            pb.setQnt(pb.getQnt() - 1);
            productBasketRepository.save(pb);
        } else {
            throw new NoSuchElementException("min quantity");
        }

    }
    @Override
    public void deleteProductFromBasket(Long id){
        ProductBasket pb= productBasketRepository.findById(id).get();
        productBasketRepository.delete(pb);
    }
    @Override
    public float priceBasket(Long idUser,String coupon){
        User u = userRepository.findById(idUser).get();
        Basket b = u.getBasketU();
        Coupon c=couponRepository.getCouponByCode(coupon);
        float price=0;
        List<ProductBasket> listProduct =productBasketRepository.findAll();
        for (ProductBasket list : listProduct){
            if(list.getBasket().getIdBasket()==b.getIdBasket()){
               if(list.getProduct().getPriceAfterSales()!=0) {
                   price=price+(list.getProduct().getPriceAfterSales()*list.getQnt());
               }
               else{
                   price=price+(list.getProduct().getPriceProduct()*list.getQnt());
               }
            }
        }
        if(c.getDiscount()!=0){
              price=price-c.getDiscount();
        } else if (c.getPercentage()!=0) {
           price= price-price*c.getPercentage()/100;
        }
        return price;
    }
    @Override
    public int nbProductOfBasket(Long idUser){
        User u = userRepository.findById(idUser).get();
        Basket b = u.getBasketU();
        int nb=0;
        List<ProductBasket> listProduct =productBasketRepository.findAll();
        for (ProductBasket list : listProduct){
            if(list.getBasket().getIdBasket()==b.getIdBasket()){
              nb=nb+list.getQnt();
            }  
        }
        return nb;
    }
}
