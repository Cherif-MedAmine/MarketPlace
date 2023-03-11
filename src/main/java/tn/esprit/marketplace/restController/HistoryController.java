package tn.esprit.marketplace.restController;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.marketplace.entities.History;
import tn.esprit.marketplace.services.interfaces.IHistoryService;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/history")
public class HistoryController {

    IHistoryService iWorkflowService;

    @PostMapping("/addHistory/{idTransaction}")
    public void addHistory(@PathVariable("idTransaction") Long idTransaction) {
        iWorkflowService.addHistory(idTransaction);
    }

    @GetMapping("/getAllHistories")
    public List<History> getAllHistories() {
        return iWorkflowService.getAllHistories();
    }

    @GetMapping("/getHistoriesBySeller/{idStore}")
    public List<History> getHistoriesBySeller(@PathVariable("idStore") Long idStore) {
        return iWorkflowService.getHistoriesBySeller(idStore);
    }

    @GetMapping("/getHistoriesBySellerDateBetween")
    public List<History> getHistoriesBySellerDateBetween(@RequestParam("idStore") Long idStore,
                                                         @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                                                         @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        return iWorkflowService.getHistoriesBySellerDateBetween(idStore, startDate, endDate);
    }

    @GetMapping("/getIncomeBySeller/{idStore}")
    public float getIncomeBySeller(@PathVariable("idStore") Long idStore) {
        return iWorkflowService.getIncomeBySeller(idStore);
    }

    @GetMapping("/getIncomeByDateBetween")
    public float getIncomeByDateBetween(@RequestParam("idStore") Long idStore,
                                        @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                                        @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        return iWorkflowService.getIncomeByDateBetween(idStore, startDate, endDate);
    }

    @GetMapping("/getHistoriesByCategory/{idCategory}")
    public List<History> getHistoriesByCategory(@PathVariable("idCategory") Long idCategory) {
        return iWorkflowService.getHistoriesByCategory(idCategory);
    }

    @GetMapping("/getHistoriesByCategoryDateBetween")
    public List<History> getHistoriesByCategoryDateBetween(@RequestParam("idCategory") Long idCategory,
                                                           @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                                                           @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        return iWorkflowService.getHistoriesByCategoryDateBetween(idCategory, startDate, endDate);
    }

}
