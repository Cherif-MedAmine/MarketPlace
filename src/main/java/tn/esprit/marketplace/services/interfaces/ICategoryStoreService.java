package tn.esprit.marketplace.services.interfaces;

import tn.esprit.marketplace.entities.CategoryStore;

public interface ICategoryStoreService {

    CategoryStore addCategoryStore(CategoryStore categoryStore);

    CategoryStore findCategoryStoreById(Long idCategoryStore);

    CategoryStore findCategoryStoreByName(String name);

    CategoryStore updateCategoryStore(CategoryStore categoryStore);

    void deleteCategoryStore(Long id);
}
