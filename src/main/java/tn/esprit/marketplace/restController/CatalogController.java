package tn.esprit.marketplace.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.marketplace.entities.Catalog;
import tn.esprit.marketplace.services.interfaces.ICatalogService;


import java.util.List;
@RestController
@RequestMapping("/api/catalog")
public class CatalogController {
    @Autowired
    ICatalogService iCatalogService;
    @GetMapping
    public List<Catalog> getAllCatalogs() {
        return iCatalogService.getAllCatalogs();
    }

    @GetMapping("/GetCatalogById")
    public Catalog getCatalogById(@PathVariable Long idCatalog) {
        return iCatalogService.getCatalogById(idCatalog);
    }

    @PostMapping("/AddCatalog")
    public void addCatalog(@RequestBody Catalog catalog) {
        iCatalogService.addCatalog(catalog);
    }
    @PutMapping("UpdateCatalog")
    public void updateCatalog(@PathVariable Long idCatalog, @RequestBody Catalog catalog) {
        Catalog existingCatalog = iCatalogService.getCatalogById(idCatalog);
        if (existingCatalog != null) {
            existingCatalog.setNameCatalog(catalog.getNameCatalog());

            iCatalogService.updateCatalog(existingCatalog);
        } else {
            // handle the case where the Catalog is not found
        }
    }


    @DeleteMapping("DeletCatalog")
    public void deleteCatalog(@RequestParam long idCatalog){
        iCatalogService.deleteCatalog(idCatalog);
    }

}


