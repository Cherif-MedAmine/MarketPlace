package tn.esprit.marketplace.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.marketplace.entities.CategoryStore;
import tn.esprit.marketplace.services.interfaces.ICategoryStoreService;

import java.util.List;


@RestController
@RequestMapping("/api/categoryStore")
public class CategoryStoreController {

    @Autowired
    ICategoryStoreService iCategoryStoreService;

    @PostMapping("/addCategoryStore")
    CategoryStore addCategoryStore(@RequestBody CategoryStore categoryStore) {
        return iCategoryStoreService.addCategoryStore(categoryStore);
    }

    @GetMapping("/findCategoryStoreById/{idCategoryStore}")
    public CategoryStore findCategoryStoreById(@PathVariable("idCategoryStore") Long idCategoryStore) {
        return iCategoryStoreService.findCategoryStoreById(idCategoryStore);
    }

    @GetMapping("/findCategoryStore/{categoryStoreName}")
    public CategoryStore findCategoryStoreByName(@PathVariable("categoryStoreName") String name) {
        return iCategoryStoreService.findCategoryStoreByName(name);
    }

    @GetMapping("/findAllCategoryStores")
    public List<CategoryStore> findAllCategoryStores() {
        return iCategoryStoreService.findAllCategoryStores();
    }

    @PutMapping("/updateCategoryStore")
    public CategoryStore updateCategoryStore(@RequestBody CategoryStore categoryStore) {
        return iCategoryStoreService.updateCategoryStore(categoryStore);
    }

    @DeleteMapping("/deleteCategoryStore/{categoryStoreId}")
    public void deleteCategoryStore(@PathVariable("categoryStoreId") Long id) {
        iCategoryStoreService.deleteCategoryStore(id);
    }

}
