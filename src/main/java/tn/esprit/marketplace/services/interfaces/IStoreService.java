package tn.esprit.marketplace.services.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tn.esprit.marketplace.entities.Product;
import tn.esprit.marketplace.entities.Store;

import java.util.List;

public interface IStoreService {

    Store addStore(Store store);

    Store findStoreById(Long idStore);

    Store findStoreByName(String storeName);

    List<Store> findStoresByCategoryName(String categoryName);

    List<Store> findAllStores();

    Page<Store> findAllStoresPageable(Pageable pageable);

    Store updateStore(Store store);

    void deleteStore(Long id);

    void affectProductToStore(Long idProduct, Long idStore);

    void affectCategoryToStore(Long idCategory, Long idStore);

    List<Product> findProductsByStoreId(Long IdStore);

    List<Store> getStoresSortedByLikes();

}
