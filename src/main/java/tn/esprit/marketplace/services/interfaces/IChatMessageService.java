package tn.esprit.marketplace.services.interfaces;

import tn.esprit.marketplace.entities.ChatMessage;

import java.time.LocalDateTime;
import java.util.List;

public interface IChatMessageService {
    List<ChatMessage> getAllMessages();

    void saveMessage(ChatMessage message);

    List<ChatMessage> getMessagesSince(LocalDateTime since);
}
