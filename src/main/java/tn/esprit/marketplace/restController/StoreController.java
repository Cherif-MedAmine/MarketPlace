package tn.esprit.marketplace.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import tn.esprit.marketplace.entities.Product;
import tn.esprit.marketplace.entities.Store;
import tn.esprit.marketplace.services.interfaces.IStoreService;

import java.util.List;

@RestController
@RequestMapping("/api/store")
public class StoreController {

    @Autowired
    IStoreService iStoreService;

    @PostMapping("/addStore")
    Store addStore(@RequestBody Store store) {
        return iStoreService.addStore(store);
    }

    @GetMapping("/findStoreById/{idStore}")
    public Store findStoreById(@PathVariable("idStore") Long idStore) {
        return iStoreService.findStoreById(idStore);
    }

    @GetMapping("/findStoreByName/{storeName}")
    public Store findStoreByName(@PathVariable("storeName") String storeName) {
        return iStoreService.findStoreByName(storeName);
    }

    @GetMapping("/findStoresByCategoryName/{categoryName}")
    public List<Store> findStoresByCategoryName(@PathVariable("categoryName") String categoryName) {
        return iStoreService.findStoresByCategoryName(categoryName);
    }

    @GetMapping("/findAllStores")
    public List<Store> findAllStores() {
        return iStoreService.findAllStores();
    }

    @GetMapping("/findAllStoresPageable")
    public Page<Store> findAllStoresPageable(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                     @RequestParam(value = "size", defaultValue = "3") Integer size) {
        PageRequest request = PageRequest.of(page - 1, size);
        return iStoreService.findAllStoresPageable(request);
    }

    @PutMapping("/updateStore")
    public Store updateStore(@RequestBody Store store) {
        return iStoreService.updateStore(store);
    }

    @DeleteMapping("/deleteStore/{id}")
    public void deleteStore(@PathVariable("id") Long id) {
        iStoreService.deleteStore(id);
    }

    @PutMapping("/affectStoreToProduct/{idProduct}/{idStore}")
    public void affectStoreToProduct(@PathVariable("idProduct") Long idProduct, @PathVariable("idStore") Long idStore) {
        iStoreService.affectProductToStore(idProduct, idStore);
    }

    @PutMapping("/affectCategoryToStore/{idCategory}/{idStore}")
    public void affectCategoryToStore(@PathVariable("idCategory") Long idCategory, @PathVariable("idStore") Long idStore) {
        iStoreService.affectCategoryToStore(idCategory, idStore);
    }

    @GetMapping("/findProductsByStoreId/{idStore}")
    public List<Product> findProductsByStoreId(@PathVariable("idStore") Long idStore) {
        return iStoreService.findProductsByStoreId(idStore);
    }

    @GetMapping("/getStoresSortedByLikes")
    public List<Store> getStoresSortedByLikes() {
        return iStoreService.getStoresSortedByLikes();
    }

}
