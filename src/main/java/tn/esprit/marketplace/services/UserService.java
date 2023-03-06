package tn.esprit.marketplace.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.marketplace.entities.User;
import tn.esprit.marketplace.repositories.*;
import tn.esprit.marketplace.services.interfaces.IUserService;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;


    @Override
    public User addUser(User user){

        return userRepository.save(user);
    }





}
