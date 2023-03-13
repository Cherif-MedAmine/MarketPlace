package tn.esprit.marketplace.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.marketplace.entities.Catalog;
import tn.esprit.marketplace.entities.FAQ;
import tn.esprit.marketplace.entities.Product;
import tn.esprit.marketplace.services.FAQService;
import tn.esprit.marketplace.services.interfaces.IFAQService;

import java.util.List;

@RestController
@RequestMapping("/api/chatbot")
public class FAQController {

    @Autowired
    private IFAQService ifaqService;

    @GetMapping("/answer")
    public ResponseEntity<String> getAnswer(@RequestParam("q") String question) {
        String answer = ifaqService.findAnswerByQuestion(question);
        if (answer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(answer);
    }

    @GetMapping("")
    public List<FAQ> getAllFAQs() {
        return ifaqService.getAllFAQs();
    }

    @GetMapping("/{id}")
    public FAQ getFAQById(@PathVariable(value = "id") Long id) {
        return ifaqService.getFAQById(id);
    }

    @PostMapping("/add")
    public void addFAQ(@RequestBody FAQ faq) {
        ifaqService.addFAQ(faq);
    }
    @PutMapping("/update")
    public FAQ updateFAQ(@RequestBody FAQ faq) {
        return ifaqService.updateFAQ(faq);
    }


    @DeleteMapping("Delete")
    public void deleteFAQ(@RequestParam long id){
        ifaqService.deleteFAQ(id);
    }

}
