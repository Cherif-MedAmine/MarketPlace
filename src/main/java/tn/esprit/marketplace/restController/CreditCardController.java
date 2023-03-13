package tn.esprit.marketplace.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.marketplace.entities.CreditCard;
import tn.esprit.marketplace.services.interfaces.ICreditCardService;
import tn.esprit.marketplace.services.ResourceNotFoundException;

import java.util.List;

@RestController
public class CreditCardController {

    @Autowired
    ICreditCardService iCreditCardService;

    @PostMapping("AddCreditCard")
    CreditCard addCreditCard(@RequestBody CreditCard creditCard) {

        return iCreditCardService.addCreditCard(creditCard);
    }


    @PutMapping("UpdateCreditCard/{id}")
    public CreditCard updateCreditCard(@PathVariable("id") long idCreditCard, @RequestBody CreditCard creditCard) throws ResourceNotFoundException {
        return iCreditCardService.updateCreditCard(idCreditCard, creditCard);
    }



    @DeleteMapping("DeleteCreditCard/{id}")
    public CreditCard deleteCreditCard(@PathVariable("id") long idCreditCard) throws ResourceNotFoundException {
        return iCreditCardService.deleteCreditCard(idCreditCard);

    }

    @GetMapping("GetAllCreditCards")
    public List<CreditCard> getAllCreditCards() {

        return iCreditCardService.getAllCreditCards();
    }

    @GetMapping("GetCreditCardById/{id}")
    public CreditCard getCreditCardById(@PathVariable("id") long idCreditCard) throws ResourceNotFoundException {
        return iCreditCardService.getCreditCardById(idCreditCard);
    }
}
