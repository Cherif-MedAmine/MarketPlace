package tn.esprit.marketplace.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.marketplace.entities.Basket;
import tn.esprit.marketplace.repositories.*;

@Service
public class BasketService implements IBasketService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AttachementRepository attachementRepository;
    @Autowired
    FavorisReopository favorisReopository;
    @Autowired
    BasketRepository basketRepository;
    @Autowired
    ProductRepository productRepository;
    @Override
    public Basket addBasket(Basket basket){

       return basketRepository.save(basket);


    }
}
