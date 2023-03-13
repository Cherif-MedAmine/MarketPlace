package tn.esprit.marketplace.restController;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.marketplace.entities.Transaction;
import tn.esprit.marketplace.services.interfaces.ITransactionService;


import java.util.List;

@RestController
@RequestMapping("api/transaction")
@AllArgsConstructor
public class TransactionController {


    ITransactionService its;

    @PostMapping("add")
    Transaction addTransaction(@RequestBody Transaction transaction){
        return its.addTransaction(transaction);
    }


    @DeleteMapping("deleteById")
    public void deleteTransactionById(@RequestParam Long idTransaction){ its.deleteTransactionById(idTransaction);}

    @PutMapping("Update/{idTransaction}")
    public ResponseEntity<Transaction> updateTransactionById(@PathVariable Long idTransaction, @RequestBody Transaction transaction){
        Transaction transactionU = its.updateTransactionById(idTransaction,transaction);
        return transactionU != null ? ResponseEntity.ok(transactionU) : ResponseEntity.notFound().build();
    }

    @GetMapping("GetListTransaction")
    public List<Transaction> getListTransaction(){
        return its.getListTransaction();
    }




}
