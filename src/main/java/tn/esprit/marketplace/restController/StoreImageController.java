package tn.esprit.marketplace.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.marketplace.services.StoreImageService;

import java.io.IOException;

@RestController
@RequestMapping("/api/storeImage")
public class StoreImageController {

    @Autowired
    private StoreImageService storeImageService;

    @PostMapping("/{idStore}")
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file,@PathVariable("idStore") Long idStore) throws IOException {
        String uploadImage = storeImageService.uploadImage(file, idStore);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping("/{idStoreImage}")
    public ResponseEntity<?> downloadImage(@PathVariable Long idStoreImage) {
        byte[] storeImage = storeImageService.downloadImage(idStoreImage);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(storeImage);
    }

    @PutMapping("/{idStore}/{idStoreImage}")
    public ResponseEntity<?> updateImage(@RequestParam("image") MultipartFile file,@PathVariable("idStore") Long idStore,@PathVariable("idStoreImage") Long idStoreImage) throws IOException {
        String updateImage = storeImageService.updateImage(file, idStore, idStoreImage);
        return ResponseEntity.status(HttpStatus.OK)
                .body(updateImage);
    }

}
