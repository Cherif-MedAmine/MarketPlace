package tn.esprit.marketplace.services.interfaces;



import tn.esprit.marketplace.entities.Transaction;

import java.util.List;

public interface ITransactionService {

    Transaction addTransaction(Transaction transaction);


    void deleteTransactionById(Long idTransaction);

    Transaction updateTransactionById(Long idTransaction,Transaction transaction);

    public List<Transaction> getListTransaction();



}
