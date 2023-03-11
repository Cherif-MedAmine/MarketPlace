package tn.esprit.marketplace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.marketplace.entities.History;

import java.util.Date;
import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History,Long> {

    List<History> getHistoriesBySeller(String seller);
    List<History> getHistoriesBySellerAndTransactionDateLike(String storeName, Date date);

    /*@Query("SELECT SUM(w.productPrice) FROM Workflow w WHERE w.transactionDate LIKE %:date%")
    float getTotalProductPriceByDate(@Param("date") Date date);*/
    @Query("SELECT SUM(h.productPrice) FROM History h WHERE h.seller = :seller")
    float sumProductPriceBySeller(@Param("seller") String seller);

    List<History> getHistoriesByProductCategory(String categoryName);
}
