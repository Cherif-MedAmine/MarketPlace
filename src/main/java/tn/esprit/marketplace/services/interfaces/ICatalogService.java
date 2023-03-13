package tn.esprit.marketplace.services.interfaces;

import tn.esprit.marketplace.entities.Catalog;

import java.util.List;

public interface ICatalogService {
    List<Catalog> getAllCatalogs();

    Catalog getCatalogById(Long idCatalog);

    void addCatalog(Catalog catalog);

    void updateCatalog(Catalog catalog);

    void deleteCatalog(Long idCatalog);



}
