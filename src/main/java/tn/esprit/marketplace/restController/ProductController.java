package tn.esprit.marketplace.restController;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.marketplace.entities.AttachementProduct;
import tn.esprit.marketplace.entities.Product;
import tn.esprit.marketplace.repositories.ProductRepository;
import tn.esprit.marketplace.services.interfaces.IAttachementService;
import tn.esprit.marketplace.services.interfaces.IProductServices;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
@AllArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
    IProductServices iProductServices;
    IAttachementService iAttachementService;
    ProductRepository productRepository;

    @PostMapping("/add")
    Product addProduct(@RequestBody Product product) {

        return iProductServices.addProduct(product);
    }
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return iProductServices.updateProduct(product);
    }
    @DeleteMapping("deleteProductById")
    public void deleteProductById(@RequestParam Long idProduct) {
        iProductServices.deleteProductById(idProduct);
    }

//    @PutMapping("addToBasket")
//    public Product addProductToBasket(@RequestParam Long idProduct, @RequestParam Long idUser) {
//
//        return iProductServices.addProductToBasket(idProduct, idUser);
//    }

    @PutMapping("/addToFavorite")
    public Product addProductToFavoris(@RequestParam Long idProduct, @RequestParam Long idUser) {

        return iProductServices.addProductToFavorite(idProduct, idUser);
    }

    @PostMapping(value = "/add/images", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public Set<AttachementProduct> addattachement(@RequestPart("attachement") MultipartFile[] attachement ,@RequestParam("product") String productJson) {
         // Product p=productRepository.findById(id).get();

    ObjectMapper objectMapper = new ObjectMapper();
    try {
        Product product = objectMapper.readValue(productJson, Product.class);
        productRepository.save(product);
            Set<AttachementProduct> images = uploadImage(attachement);
            for(AttachementProduct att:images){
                att.setAttproduct(product);
                iAttachementService.addAttachment(att);
            }
//            product.getAttachmentProducts().addAll(images);
//            iProductServices.addProduct(product);
           return images;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Set<AttachementProduct> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<AttachementProduct> images = new HashSet<>();

        for (MultipartFile file : multipartFiles) {
            AttachementProduct image = new AttachementProduct(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            images.add(iAttachementService.addAttachment(image));
        }
        return images;
    }

    @PutMapping("LikeProduct")
    public Product likeProduct(@RequestParam Long idProduct) {

        return iProductServices.likeProduct(idProduct);
    }

    @PutMapping("DesikeProduct")
    public Product likeProduct2(@RequestParam Long idProduct) {

        return iProductServices.likeProduct2(idProduct);
    }
    @PutMapping("addCategory")
    public  Product addCategoryToProduct(@RequestParam Long idProduct,@RequestParam Long idCategory){

        return iProductServices.addCategoryToProduct(idProduct,idCategory);
    }
    @GetMapping("get_all")
    public List<Product> getAllProduct(){

        return iProductServices.getAllProduct();
    }
    @GetMapping("get_product_category")
    public List<Product> getProductByCategory(@RequestParam String categoryName){

        return iProductServices.getProductByCategory(categoryName);
    }

}
