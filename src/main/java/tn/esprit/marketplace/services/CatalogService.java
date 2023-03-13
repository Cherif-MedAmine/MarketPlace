package tn.esprit.marketplace.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.marketplace.entities.Catalog;
import tn.esprit.marketplace.repositories.CatalogRepository;
import tn.esprit.marketplace.repositories.ProductRepository;
import tn.esprit.marketplace.repositories.UserRepository;
import tn.esprit.marketplace.services.interfaces.ICatalogService;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
@AllArgsConstructor
public class CatalogService implements ICatalogService {




    ProductRepository productRepository;

    CatalogRepository catalogRepository;

    UserRepository userRepository;

    @Override
    public List<Catalog> getAllCatalogs() {
        return catalogRepository.findAll();
    }

    @Override
    public Catalog getCatalogById(Long idCatalog) {
        Optional<Catalog> catalog = catalogRepository.findById(idCatalog);
        if (catalog.isPresent()) {
            return catalog.get();
        } else {
            throw new RuntimeException("Catalog not found for id: " + idCatalog);
        }
    }

    @Override
    public void addCatalog(Catalog catalog) {
        catalogRepository.save(catalog);
    }

    @Override
    public void updateCatalog(Catalog catalog) {
        catalogRepository.save(catalog);
    }

    @Override
    public void deleteCatalog(Long idCatalog) {
        catalogRepository.deleteById(idCatalog);
    }



}
