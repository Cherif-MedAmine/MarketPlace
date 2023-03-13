package tn.esprit.marketplace.services.interfaces;

import tn.esprit.marketplace.entities.FAQ;

import java.util.List;

public interface IFAQService {
    String findAnswerByQuestion(String question);
    List<FAQ> getAllFAQs();

    FAQ getFAQById(Long id);

    FAQ addFAQ(FAQ faq);

    FAQ updateFAQ(FAQ  faq);

    void deleteFAQ(Long id);
}

