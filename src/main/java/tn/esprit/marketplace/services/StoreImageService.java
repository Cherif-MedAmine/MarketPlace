package tn.esprit.marketplace.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.marketplace.entities.Store;
import tn.esprit.marketplace.entities.StoreImage;
import tn.esprit.marketplace.repositories.StoreImageRepository;
import tn.esprit.marketplace.repositories.StoreRepository;
import tn.esprit.marketplace.services.interfaces.IStoreImageService;
import tn.esprit.marketplace.utils.ImageUtils;

import java.io.IOException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StoreImageService implements IStoreImageService {

    StoreImageRepository storeImageRepository;
    StoreRepository storeRepository;

    /**
     * Uploads an image file and associates it with a store.
     *
     * @param file    The image file to be uploaded
     * @param idStore The ID of the store to which the image will be associated
     * @return A message indicating success or failure of the upload operation
     * @throws IOException If there is an I/O error during the upload process
     */
    @Override
    public String uploadImage(MultipartFile file, Long idStore) throws IOException {
        // Save the uploaded image file to the database as a new StoreImage object
        StoreImage storeImage = storeImageRepository.save(StoreImage.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());
        // If the StoreImage was successfully saved to the database
        if (storeImage != null) {
            // Find the store with the given ID
            Optional<Store> optionalStore = storeRepository.findById(idStore);
            if (optionalStore.isPresent()) {
                Store store = optionalStore.get();
                // Associate the StoreImage with the store and save the updated store to the database
                store.setStoreImage(storeImage);
                storeRepository.save(store);
                // Return a success message indicating the name of the uploaded file
                return "file uploaded successfully : " + file.getOriginalFilename();
            } else {
                // If the store with the given ID is not found, return an error message
                return "store not found with id: " + idStore;
            }
        }
        return null;
    }

    /**
     * This method downloads an image from the database by its ID.
     * It retrieves the image data from the database using the StoreImageRepository,
     * decompresses it using ImageUtils, and returns the byte array representing the image.
     *
     * @param idStoreImage the ID of the image to download
     * @return the byte array representing the downloaded image
     */
    @Override
    public byte[] downloadImage(Long idStoreImage) {
        // Retrieve the image data from the database using its ID
        Optional<StoreImage> dbImageData = storeImageRepository.findById(idStoreImage);
        // Decompress the image data using ImageUtils
        byte[] images = ImageUtils.decompressImage(dbImageData.get().getImageData());
        // Return the byte array representing the downloaded image
        return images;
    }

    /**
     * This method updates an image in the database by its ID.
     * It retrieves the StoreImage entity from the database using the StoreImageRepository,
     * updates its name, type, and imageData using the provided MultipartFile, and saves it back to the database.
     * It then updates the Store entity associated with the image by setting its StoreImage property to the updated StoreImage.
     *
     * @param file         the MultipartFile containing the updated image data
     * @param idStore      the ID of the Store associated with the image to update
     * @param idStoreImage the ID of the image to update
     * @return a message indicating the status of the update
     * @throws IOException if there is an error reading the image data from the MultipartFile
     */
    @Override
    public String updateImage(MultipartFile file, Long idStore, Long idStoreImage) throws IOException {
        // Retrieve the StoreImage entity from the database using its ID
        Optional<StoreImage> optionalStoreImage = storeImageRepository.findById(idStoreImage);
        if (optionalStoreImage.isPresent()) {
            StoreImage storeImage = optionalStoreImage.get();
            // Update the name, type, and imageData of the StoreImage entity using the provided MultipartFile
            storeImage.setName(file.getOriginalFilename());
            storeImage.setType(file.getContentType());
            storeImage.setImageData(ImageUtils.compressImage(file.getBytes()));
            storeImageRepository.save(storeImage);

            // Retrieve the Store entity associated with the updated image
            Optional<Store> optionalStore = storeRepository.findById(idStore);
            if (optionalStore.isPresent()) {
                Store store = optionalStore.get();
                // Update the Store entity by setting its StoreImage property to the updated StoreImage
                store.setStoreImage(storeImage);
                storeRepository.save(store);
                return "file updated successfully : " + file.getOriginalFilename();
            } else {
                return "store not found with id: " + idStore;
            }
        } else {
            return "store image not found with id: " + idStoreImage;
        }
    }
}
