package tn.esprit.marketplace.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.marketplace.entities.CategoryStore;
import tn.esprit.marketplace.exception.GenericException;
import tn.esprit.marketplace.repositories.CategoryStoreRepository;
import tn.esprit.marketplace.services.interfaces.ICategoryStoreService;
import tn.esprit.marketplace.utils.ConstUtils;

import java.util.Optional;

@Service
public class CategoryStoreService implements ICategoryStoreService {

    @Autowired
    CategoryStoreRepository categoryStoreRepository;

    @Override
    public CategoryStore addCategoryStore(CategoryStore categoryStore) {
        categoryStoreRepository.save(categoryStore);
        return categoryStore;
    }

    @Override
    public CategoryStore findCategoryStoreById(Long idCategoryStore) {
        CategoryStore categoryStore = categoryStoreRepository.findById(idCategoryStore).get();
        if (categoryStore == null) throw new GenericException(ConstUtils.CATEGORY_STORE_NOT_EXIST);
        return categoryStore;
    }

    @Override
    public CategoryStore findCategoryStoreByName(String name) {
        CategoryStore categoryStore = categoryStoreRepository.getByNameCategoryStore(name);
        if (categoryStore == null) throw new GenericException(ConstUtils.CATEGORY_STORE_NOT_EXIST);
        return categoryStore;
    }

    @Override
    public CategoryStore updateCategoryStore(CategoryStore categoryStore) {
        categoryStoreRepository.save(categoryStore);
        return categoryStore;

    }

    @Override
    public void deleteCategoryStore(Long id) {
        Optional<CategoryStore> optionalCategoryStore = categoryStoreRepository.findById(id);
        if (optionalCategoryStore.isPresent())
            categoryStoreRepository.deleteById(id);
    }
}
