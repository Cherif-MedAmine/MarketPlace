package tn.esprit.marketplace.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.marketplace.entities.ChatMessage;
import tn.esprit.marketplace.repositories.ChatMessageRepository;
import tn.esprit.marketplace.services.interfaces.IChatMessageService;

import java.time.LocalDateTime;
import java.util.List;
@Slf4j
@Service
@AllArgsConstructor
public class ChatMessageService implements IChatMessageService {
    ChatMessageRepository chatMessageRepository;



    @Override
    public List<ChatMessage> getAllMessages() {
        return chatMessageRepository.findAllByOrderByCreatedAtAsc();
    }

    @Override
    public void saveMessage(ChatMessage message) {
        message.setCreatedAt(LocalDateTime.now());
        chatMessageRepository.save(message);
    }

    @Override
    public List<ChatMessage> getMessagesSince(LocalDateTime since) {
        return chatMessageRepository.findAllByCreatedAtGreaterThanEqualOrderByCreatedAtAsc(since);
    }
}
