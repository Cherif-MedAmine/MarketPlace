package tn.esprit.marketplace.restController;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.marketplace.entities.ChatMessage;
import tn.esprit.marketplace.services.interfaces.IChatMessageService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/message")
public class ChatMessageController {

    IChatMessageService iChatMessageService ;
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        iChatMessageService.saveMessage(chatMessage);
        return chatMessage;
    }

    @MessageMapping("/chat.getMessagesSince")
    @SendTo("/topic/public")
    public List<ChatMessage> getMessagesSince(@Payload LocalDateTime since) {
        return iChatMessageService.getMessagesSince(since);
    }
    @GetMapping("/messages")
    public List<ChatMessage> getAllMessages() {
        return iChatMessageService.getAllMessages();
    }
}
