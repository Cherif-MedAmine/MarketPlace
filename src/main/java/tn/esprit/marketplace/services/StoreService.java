package tn.esprit.marketplace.services;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import tn.esprit.marketplace.entities.CategoryStore;
import tn.esprit.marketplace.entities.Product;
import tn.esprit.marketplace.entities.Store;
import tn.esprit.marketplace.exception.GenericException;
import tn.esprit.marketplace.repositories.CategoryStoreRepository;
import tn.esprit.marketplace.repositories.ProductRepository;
import tn.esprit.marketplace.repositories.StoreRepository;
import tn.esprit.marketplace.services.interfaces.IStoreService;
import tn.esprit.marketplace.utils.ConstUtils;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StoreService implements IStoreService {

    StoreRepository storeRepository;
    ProductRepository productRepository;
    CategoryStoreRepository categoryStoreRepository;

    @Override
    public Store addStore(Store store) {
        if (ObjectUtils.isEmpty(store))
            throw new GenericException(ConstUtils.STORE_NOT_EXIST);
        store.setStatus(false);
        return storeRepository.save(store);
    }

    @Override
    public Store findStoreById(Long idStore) {
        Store store = storeRepository.findById(idStore).get();
        if (store == null) throw new GenericException(ConstUtils.STORE_NOT_EXIST);
        return store;
    }

    @Override
    public Store findStoreByName(String storeName) {
        Store store = storeRepository.getStoreByNameStore(storeName);
        if (store == null) throw new GenericException(ConstUtils.STORE_NOT_EXIST);
        return store;
    }

    @Override
    public List<Store> findStoresByCategoryName(String categoryName) {
        CategoryStore categoryStore = categoryStoreRepository.getByNameCategoryStore(categoryName);
        List<Store> stores = storeRepository.getStoresByCategoryStores(categoryStore);
        if (stores == null) throw new GenericException(ConstUtils.STORE_NOT_EXIST);
        return stores;
    }

    @Override
    public List<Store> findAllStores() {
        List<Store> stores = storeRepository.findAll();
        if (stores == null) throw new GenericException(ConstUtils.STORE_NOT_EXIST);
        return stores;
    }

    @Override
    public Page<Store> findAllStoresPageable(Pageable pageable) {
        return storeRepository.findAll(pageable);
    }

    @Override
    public Store updateStore(Store store) {
        storeRepository.save(store);
        return store;
    }

    @Override
    public void deleteStore(Long id) {
        Optional<Store> optionalStore = storeRepository.findById(id);
        if (optionalStore.isPresent())
            storeRepository.deleteById(id);
    }

    @Override
    public void affectProductToStore(Long idProduct, Long idStore) {
        Product product = productRepository.findById(idProduct).get();
        Store store = storeRepository.findById(idStore).get();
        product.setStore(store);
        productRepository.save(product);
    }

    @Override
    public void affectCategoryToStore(Long idCategory, Long idStore) {
        /*CategoryStore categoryStore = categoryStoreRepository.findById(idCategory)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Store store = storeRepository.findById(idStore)
                .orElseThrow(() -> new RuntimeException("Store not found"));

        store.setCategoryStore(categoryStore);
        categoryStoreRepository.save(categoryStore);*/
    }

    @Override
    public List<Product> findProductsByStoreId(Long idStore) {
        return productRepository.findProductsByStoreId(idStore);
    }

    @Override
    public List<Store> getStoresSortedByLikes() {
        List<Store> stores = storeRepository.findAllOrderByLikes();
        return stores;
    }

}
