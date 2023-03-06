package tn.esprit.marketplace.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.marketplace.entities.AttachementProduct;
import tn.esprit.marketplace.repositories.*;
import tn.esprit.marketplace.services.interfaces.IAttachementService;


@AllArgsConstructor
@Service
public class AttachementService implements IAttachementService {

    UserRepository userRepository;
    AttachmentRepository attachmentRepository;

    BasketRepository basketRepository;

    ProductRepository productRepository;

    @Override
    public AttachementProduct addAttachment(AttachementProduct attachementProduct){

        return attachmentRepository.save(attachementProduct);
    }


}
