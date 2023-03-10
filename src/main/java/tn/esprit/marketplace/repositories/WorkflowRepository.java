package tn.esprit.marketplace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.marketplace.entities.Workflow;

import java.util.Date;
import java.util.List;

@Repository
public interface WorkflowRepository extends JpaRepository<Workflow,Long> {

    List<Workflow> getWorkflowsBySeller(String seller);
    List<Workflow> getWorkflowsBySellerAndTransactionDateLike(String storeName, Date date);

    /*@Query("SELECT SUM(w.productPrice) FROM Workflow w WHERE w.transactionDate LIKE %:date%")
    float getTotalProductPriceByDate(@Param("date") Date date);*/
    @Query("SELECT SUM(w.productPrice) FROM Workflow w WHERE w.seller = :seller")
    float sumProductPriceBySeller(@Param("seller") String seller);

}
