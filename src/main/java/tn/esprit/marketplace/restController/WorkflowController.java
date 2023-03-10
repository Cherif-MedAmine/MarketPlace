package tn.esprit.marketplace.restController;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.marketplace.entities.Workflow;
import tn.esprit.marketplace.services.interfaces.IWorkflowService;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/workflow")
public class WorkflowController {

    IWorkflowService iWorkflowService;

    @PostMapping("/addWorkflow/{idTransaction}")
    public void addWorkflow(@PathVariable("idTransaction") Long idTransaction) {
        iWorkflowService.addWorkflow(idTransaction);
    }

    @GetMapping("/getAllWorkflows")
    public List<Workflow> getAllWorkflows() {
        return iWorkflowService.getAllWorkflows();
    }

    @GetMapping("/getWorkflowsByStoreId/{idStore}")
    public List<Workflow> getWorkflowsByStoreId(@PathVariable("idStore") Long idStore) {
        return iWorkflowService.getWorkflowsByStoreId(idStore);
    }

    @GetMapping("/getWorkflowsByDateBetween/{idStore}")
    public List<Workflow> getWorkflowsByDateBetween(@PathVariable("idStore") Long idStore,
                                             @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                                             @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        return iWorkflowService.getWorkflowsByDateBetween(idStore, startDate, endDate);
    }

    @GetMapping("/getIncomeBySeller/{idStore}")
    public float getIncomeBySeller(@PathVariable("idStore") Long idStore) {
        return iWorkflowService.getIncomeBySeller(idStore);
    }

    @GetMapping("/getIncomeByDate/{idStore}")
    public float getIncomeByDate(@PathVariable("idStore") Long idStore,
                                  @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
        return iWorkflowService.getIncomeByDate(idStore, date);
    }

}
