package tn.esprit.marketplace.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.marketplace.entities.Basket;
import tn.esprit.marketplace.entities.User;
import tn.esprit.marketplace.repositories.*;

import java.util.Collections;

@Service
public class UserService implements IUserService{
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
    public User addUser(User user){

        return userRepository.save(user);
    }





}
