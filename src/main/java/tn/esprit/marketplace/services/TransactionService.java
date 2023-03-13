package tn.esprit.marketplace.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.marketplace.entities.Transaction;
import tn.esprit.marketplace.repositories.TransactionRepository;
import tn.esprit.marketplace.services.interfaces.ITransactionService;


import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService implements ITransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }



    @Override
    public void deleteTransactionById(Long idTransaction) {
        Transaction transaction = transactionRepository.findById(idTransaction).get();
        transactionRepository.delete(transaction);
    }

    @Override
    public Transaction updateTransactionById(Long idTransaction, Transaction transaction) {
         Transaction transaction1 = transactionRepository.findById(idTransaction).get();
            transaction1.setIdTransaction(transaction.getIdTransaction());
            transaction1.setTransaction_date(transaction.getTransaction_date());
            transaction1.setTotal_amount(transaction.getTotal_amount());
            transaction1.setUsername(transaction.getUsername());

            return transactionRepository.save(transaction1);

    }

    @Override
    public List<Transaction> getListTransaction() {
        List<Transaction> transactions = new ArrayList<>();
        transactionRepository.findAll().forEach(transactions::add);
        return transactions;
    }









}
