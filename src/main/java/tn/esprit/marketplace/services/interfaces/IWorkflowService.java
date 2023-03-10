package tn.esprit.marketplace.services.interfaces;

import tn.esprit.marketplace.entities.Workflow;

import java.util.Date;
import java.util.List;

public interface IWorkflowService {

    void addWorkflow(Long idBasket);
    List<Workflow> getAllWorkflows();
    List<Workflow> getWorkflowsByStoreId(Long idStore);
    List<Workflow> getWorkflowsByDateBetween(Long idStore, Date startDate, Date endDate);
    float getIncomeBySeller(Long idStore);
    float getIncomeByDate(Long idStore, Date date);


}
