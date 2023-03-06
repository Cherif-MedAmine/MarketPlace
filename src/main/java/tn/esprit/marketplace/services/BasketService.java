package tn.esprit.marketplace.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.marketplace.entities.Basket;
import tn.esprit.marketplace.repositories.*;
import tn.esprit.marketplace.services.interfaces.IBasketService;

@Service
public class BasketService implements IBasketService {
    @Autowired
    BasketRepository basketRepository;

    @Override
    public Basket addBasket(Basket basket){

       return basketRepository.save(basket);


    }
}
