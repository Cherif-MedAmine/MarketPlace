package tn.esprit.marketplace.services.interfaces;

import tn.esprit.marketplace.entities.CreditCard;
import tn.esprit.marketplace.services.ResourceNotFoundException;

import java.util.List;

public interface ICreditCardService {

    CreditCard addCreditCard(CreditCard creditCard);
    CreditCard updateCreditCard(long idCreditCard, CreditCard creditCard) throws ResourceNotFoundException;
    CreditCard deleteCreditCard(long idCreditCard) throws ResourceNotFoundException;
    List<CreditCard> getAllCreditCards();

    CreditCard getCreditCardById(long idCreditCard) throws ResourceNotFoundException;


}
