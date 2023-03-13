package tn.esprit.marketplace.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import tn.esprit.marketplace.entities.Catalog;
import tn.esprit.marketplace.entities.FAQ;
import tn.esprit.marketplace.repositories.FAQRepository;
import tn.esprit.marketplace.services.interfaces.IFAQService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class FAQService implements IFAQService {


    private FAQRepository faqRepository;

    @Override
    public List<FAQ> getAllFAQs() {
        return faqRepository.findAll();
    }

    @Override
    public FAQ getFAQById(Long id) {
        Optional<FAQ> catalog = faqRepository.findById(id);
        if (catalog.isPresent()) {
            return catalog.get();
        } else {
            throw new RuntimeException("FAQ not found for id: " + id);
        }
    }
    @Override
    public FAQ addFAQ(FAQ faq) {
        return faqRepository.save(faq);
    }

    @Override
    public FAQ updateFAQ(FAQ faq) {
        return faqRepository.save(faq);}

        @Override
        public void deleteFAQ(Long id) {
            faqRepository.deleteById(id);
        }
    @Override
    public String findAnswerByQuestion(String question) {
        FAQ faq = faqRepository.findByQuestionIgnoreCase(question);
        if (faq == null) {
            return null;
        }
        return faq.getAnswer();
    }
}