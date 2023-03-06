package tn.esprit.marketplace.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.marketplace.entities.Basket;
import tn.esprit.marketplace.services.interfaces.IBasketService;

@RestController
@RequestMapping("/api/basket")
public class BasketController {
    @Autowired
    IBasketService iBasketService;
    @PostMapping("AddBasket")
    Basket addBasket(@RequestBody Basket basket) {
      return iBasketService.addBasket(basket);
    }
}
