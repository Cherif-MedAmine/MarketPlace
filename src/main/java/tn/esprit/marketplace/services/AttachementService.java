package tn.esprit.marketplace.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.marketplace.entities.AttachementProduct;
import tn.esprit.marketplace.repositories.*;

import java.nio.file.Paths;

@Service
public class AttachementService implements IAttachementService{
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
     public AttachementProduct addAttachement(MultipartFile[] files){


          return null;
      }

}
