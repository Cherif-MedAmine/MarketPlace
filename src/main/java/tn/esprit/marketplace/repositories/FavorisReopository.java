package tn.esprit.marketplace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.marketplace.entities.Favoris;

@Repository
public interface FavorisReopository extends JpaRepository<Favoris,Long> {
}
