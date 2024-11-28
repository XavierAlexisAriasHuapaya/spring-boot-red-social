package dev.arias.huapaya.redsocial.presentation.controller;

import java.util.List;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import dev.arias.huapaya.redsocial.persistence.entity.ChatEntity;
import dev.arias.huapaya.redsocial.service.interfaces.ChatService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class ChatWebSocketController {

    private ChatService chatService;

    @MessageMapping("/chat/notification/{userId}")
    @SendTo("/topic/notification/{userId}")
    public List<ChatEntity> chatNotification(@DestinationVariable Long userId) {
        // System.out.println("Contador: " + count);
        List<ChatEntity> notifications = this.chatService.findChatNotificationsByUser(userId);
        return notifications;
    }

}
