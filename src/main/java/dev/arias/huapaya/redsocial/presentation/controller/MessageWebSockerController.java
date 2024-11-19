package dev.arias.huapaya.redsocial.presentation.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
// import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import dev.arias.huapaya.redsocial.presentation.dto.chat.ChatWebSocketDto;

@Controller
public class MessageWebSockerController {

    // @PreAuthorize("hasAuthority('MESSAGE_WEB_SOCKET')")
    @MessageMapping("/chat/{id}")
    @SendTo("/topic/{id}")
    public ChatWebSocketDto chat(@DestinationVariable Long id, ChatWebSocketDto chatDto) {
        System.out.println(chatDto);
        return new ChatWebSocketDto(chatDto.getId(), chatDto.getMessage());
    }

}
