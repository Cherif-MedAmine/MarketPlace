package tn.esprit.marketplace.services.interfaces;

import tn.esprit.marketplace.entities.History;

import java.util.Date;
import java.util.List;

public interface IHistoryService {

    void addHistory(Long idBasket);
    List<History> getAllHistories();
    List<History> getHistoriesBySeller(Long idStore);
    List<History> getHistoriesBySellerDateBetween(Long idStore, Date startDate, Date endDate);
    float getIncomeBySeller(Long idStore);
    float getIncomeByDateBetween(Long idStore, Date startDate, Date endDate);
    List<History> getHistoriesByCategory(Long idCategory);
    List<History> getHistoriesByCategoryDateBetween(Long idCategory, Date startDate, Date endDate);


}
