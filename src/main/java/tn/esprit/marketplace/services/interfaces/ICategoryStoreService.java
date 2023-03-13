package tn.esprit.marketplace.services.interfaces;

import tn.esprit.marketplace.entities.CategoryStore;

import java.util.List;

public interface ICategoryStoreService {

    CategoryStore addCategoryStore(CategoryStore categoryStore);

    CategoryStore findCategoryStoreById(Long idCategoryStore);

    CategoryStore findCategoryStoreByName(String name);

    List<CategoryStore> findAllCategoryStores();

    CategoryStore updateCategoryStore(CategoryStore categoryStore);

    void deleteCategoryStore(Long id);
}
