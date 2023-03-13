package tn.esprit.marketplace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.marketplace.entities.Catalog;

@Repository

public interface CatalogRepository extends JpaRepository<Catalog,Long>{
}
