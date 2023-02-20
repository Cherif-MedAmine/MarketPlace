package tn.esprit.marketplace.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.marketplace.entities.Product;
import tn.esprit.marketplace.entities.User;
import tn.esprit.marketplace.repositories.ProductRepository;
import tn.esprit.marketplace.services.IAttachementService;
import tn.esprit.marketplace.services.IProductServices;


@RestController
public class ProductController {
    @Autowired
    IProductServices iProductServices;
    @PostMapping("AddProduct")
    Product addProduct(@RequestBody Product product) {

        return iProductServices.addProduct(product);
    }
    @PutMapping("AddProductToBasket")
    public Product addProductToBasket(@RequestParam Long idProduct,@RequestParam Long idUser){

        return iProductServices.addProductToBasket(idProduct,idUser);
    }
    @PutMapping("AddProductToFavoris")
    public Product addProductToFavoris(@RequestParam Long idProduct,@RequestParam Long idUser){

        return iProductServices.addProductToFavoris(idProduct,idUser);
    }

    @PutMapping("LikeProduct")
    public Product likeProduct(@RequestParam Long idProduct){

        return iProductServices.likeProduct(idProduct);
    }
    @PutMapping("DesikeProduct")
    public Product likeProduct2(@RequestParam Long idProduct) {

        return iProductServices.likeProduct2(idProduct);
    }
    @PutMapping("UpdateProduct")
    public Product updateProduct(@RequestBody Product product){
        return iProductServices.updateProduct(product);
    }
    @DeleteMapping("DeletProduct")
    public void deletProduct(@RequestBody Product product){
        iProductServices.deleteProduct(product);
    }
    @DeleteMapping("deleteProductById")
    public void deleteProductById(@RequestParam Long idProduct){
        iProductServices.deleteProductById(idProduct);
    }
}
