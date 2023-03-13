package tn.esprit.marketplace.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.marketplace.entities.CreditCard;
import tn.esprit.marketplace.repositories.CreditCardRepository;
import tn.esprit.marketplace.services.interfaces.ICreditCardService;

import java.util.List;
import java.util.Optional;

@Service
public class CreditCardService implements ICreditCardService {

    @Autowired
    CreditCardRepository creditCardRepository;

    @Override
    public CreditCard addCreditCard(CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }

    @Override
    public CreditCard updateCreditCard(long idCreditCard, CreditCard creditCard) throws ResourceNotFoundException {
        Optional<CreditCard> cardOptional = creditCardRepository.findById(idCreditCard);
        if(cardOptional.isPresent()) {
            CreditCard updatedCard = cardOptional.get();
            updatedCard.setRib(creditCard.getRib());
            return creditCardRepository.save(updatedCard);
        } else {
            throw new ResourceNotFoundException("Credit Card not found with id: " + idCreditCard);
        }
    }

    @Override
    public CreditCard deleteCreditCard(long idCreditCard) throws ResourceNotFoundException {
        Optional<CreditCard> cardOptional = creditCardRepository.findById(idCreditCard);
        if (!cardOptional.isPresent()) {
            throw new ResourceNotFoundException("Credit Card not found with id: " + idCreditCard);
        }
        creditCardRepository.deleteById(idCreditCard);
        return null;
    }

    @Override
    public List<CreditCard> getAllCreditCards() {

        return creditCardRepository.findAll();
    }

    @Override
    public CreditCard getCreditCardById(long idCreditCard) throws ResourceNotFoundException {

        Optional<CreditCard> creditCard = creditCardRepository.findById(idCreditCard);
        if (creditCard.isPresent()) {
            return creditCard.get();
        } else {
            throw new ResourceNotFoundException("Credit Card not found with id: " + idCreditCard);
        }

    }
}
