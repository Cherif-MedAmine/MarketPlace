package tn.esprit.marketplace.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.marketplace.repositories.*;

@Service
public class FavorisService implements IFavorisService{
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
}
