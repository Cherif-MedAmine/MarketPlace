package tn.esprit.marketplace.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.marketplace.entities.CategoryStore;
import tn.esprit.marketplace.entities.Store;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    Store getStoreByNameStore(String name);

    List<Store> getStoresByCategoryStores(CategoryStore categoryStore);

    Page<Store> findAllByOrderByIdStore(Pageable pageable);

    Page<Store> findAllBy(Pageable pageable);

    Store findByUserIdUser(Long idUser);

    @Query("SELECT s FROM Store s LEFT JOIN s.storeLikesStore sl GROUP BY s.idStore ORDER BY COUNT(sl.idStoreLike) DESC")
    List<Store> findAllOrderByLikes();

    @Query("SELECT s FROM Store s JOIN s.storeLikesStore sl GROUP BY s.idStore ORDER BY COUNT(sl) DESC")
    List<Store> findAllOrderByLikes2(); //Ignore stores with no likes
}
