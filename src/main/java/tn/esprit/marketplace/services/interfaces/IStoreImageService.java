package tn.esprit.marketplace.services.interfaces;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IStoreImageService {

    String uploadImage(MultipartFile file, Long idStore) throws IOException;
    byte[] downloadImage(Long idStoreImage);

    String updateImage(MultipartFile file, Long idStore, Long idStoreImage) throws IOException;

}
