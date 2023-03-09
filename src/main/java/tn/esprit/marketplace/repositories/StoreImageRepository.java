package tn.esprit.marketplace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.marketplace.entities.Store;
import tn.esprit.marketplace.entities.StoreLike;
import tn.esprit.marketplace.entities.User;

@Repository
public interface StoreImageRepository extends JpaRepository<StoreLike, Long> {

    StoreLike findByLikeUserAndLikeStore(User user, Store store);

    @Query("SELECT COUNT(sl) FROM StoreLike sl WHERE sl.likeStore = :store")
    int countLikesByStore(@Param("store") Store store);
}
