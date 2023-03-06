package tn.esprit.marketplace.restController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.marketplace.services.interfaces.IProductBasketService;

@RestController
@AllArgsConstructor
@RequestMapping("api/product_basket")
public class ProductBasketController {

    IProductBasketService productBasketService;

IProductBasketService getProductBasketService;

    @PostMapping("add")
    public void addProductToBasket(@RequestParam Long idProduct,@RequestParam Long idUser) {

         productBasketService.addProductToBasket(idProduct,idUser);
    }
    @PutMapping("increment_quantity")
    public void incrementQuantity(@RequestParam Long id){
        productBasketService.incrementQuantity(id);
    }
    @PutMapping("decrement_quantity")
    public void decrementQuantity(@RequestParam Long id){
        productBasketService.decrementQuantity(id);
    }
    @DeleteMapping("delete")
    public void deleteProductFromBasket(Long id){
        productBasketService.deleteProductFromBasket(id);

    }
    @GetMapping("price_basket")
    public float priceBasket(@RequestParam Long idUser ,@RequestParam String code){

        return productBasketService.priceBasket(idUser,code);
    }
    @GetMapping("number_product_basket")
    public int nbProductOfBasket(Long idUser){

        return productBasketService.nbProductOfBasket(idUser);
    }
}
