package tn.esprit.marketplace.services.interfaces;

import tn.esprit.marketplace.entities.Basket;
import tn.esprit.marketplace.entities.User;
import tn.esprit.marketplace.services.UserNotFoundException;

import java.util.List;

public interface IUserService {



    User addUser(User user,String roleName);
    User updateUser(long idUser, User user) throws UserNotFoundException;
    User deleteUser(long idUser) throws UserNotFoundException;
    List<User> getAllUsers();
    User getUserById(Long idUser) throws UserNotFoundException;
}
