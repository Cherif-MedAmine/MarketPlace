package tn.esprit.marketplace.restController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.marketplace.entities.CategoryProduct;
import tn.esprit.marketplace.services.interfaces.ICategoryProductService;

import java.util.List;

@RestController
@RequestMapping("api/category_product")
@AllArgsConstructor
public class CategoryProductController {
    ICategoryProductService categoryProductService;

    @PostMapping("add")
    public CategoryProduct addCategoryProduct(@RequestBody CategoryProduct categoryProduct){

        return categoryProductService.addCategoryProduct(categoryProduct);
    }
    @PutMapping("update")
    public  CategoryProduct updateCategoryProduct(@RequestBody CategoryProduct categoryProduct){
        return categoryProductService.updateCategoryProduct(categoryProduct);
    }
    @DeleteMapping("delete")
    public void deleteCategoryProduct(@RequestParam Long idCategory){

        categoryProductService.deleteCategoryProduct(idCategory);
    }
    @GetMapping("all_categorys")
    public List<CategoryProduct> getAllCategoryProducts() {

        return categoryProductService.getAllCategoryProducts();
    }
}
