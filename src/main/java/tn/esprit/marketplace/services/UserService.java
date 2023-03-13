package tn.esprit.marketplace.services;


import io.jsonwebtoken.lang.Assert;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tn.esprit.marketplace.entities.*;
import tn.esprit.marketplace.repositories.*;
import tn.esprit.marketplace.services.interfaces.IUserService;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements IUserService, UserDetailsService {
    private final UserRepository appUserRepository;


    @Autowired
    UserRepository userRepository;
    @Autowired
    AttachmentRepository attachementRepository;
    @Autowired
    FavoriteReopository favorisReopository;
    @Autowired
    BasketRepository basketRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    RoleRepository roleRepository;


    @Override
    public User addUser(User user, String roleName) throws IllegalArgumentException {

        Role role = roleRepository.findByRoleName(roleName);
        if (role == null) {
            throw new IllegalArgumentException("Invalid role name: " + roleName);
        } else {
            user.setRole(role);
            User savedUser = userRepository.save(user);
            return savedUser;
        }
    }

    public User updateUser(long idUser, User user) throws UserNotFoundException {
        Optional<User> existingUser = userRepository.findById(idUser);
        if (existingUser.isPresent()) {
            User updatedUser = existingUser.get();
            updatedUser.setUserName(user.getUserName());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setCreationDate(user.getCreationDate());
            updatedUser.setPhoneNumber(user.getPhoneNumber());
            updatedUser.setPremium(user.getPremium());
            updatedUser.setScore(user.getScore());
            updatedUser.setRole(user.getRole());
            return userRepository.save(updatedUser);
        } else {
            throw new UserNotFoundException("User not found with id: " + idUser);
        }
    }

    @Override
    public User deleteUser(long idUser) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(idUser);
        if (!userOptional.isPresent()) {
            throw new UserNotFoundException("User not found with id: " + idUser);
        }
        userRepository.deleteById(idUser);
        return null;
    }

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long idUser) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(idUser);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UserNotFoundException("User not found with id: " + idUser);
        }
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User appUser = appUserRepository.findByUsername(username);
        Assert.notNull(appUser, new UsernameNotFoundException(username).getMessage());
        return (UserDetails) new User(appUser.getUserName(), appUser.getPassword(), getAuthorities(appUser.getRole()));
    }

    private List<GrantedAuthority> getAuthorities(Role userRole) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(userRole.getRoleName()));
        return authorities;
    }
}





