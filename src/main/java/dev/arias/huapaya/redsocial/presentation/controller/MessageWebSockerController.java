package dev.arias.huapaya.redsocial.presentation.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
// import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import dev.arias.huapaya.redsocial.presentation.dto.message.MessageWebSocketDto;
import dev.arias.huapaya.redsocial.service.interfaces.MessageService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class MessageWebSockerController {

    private MessageService messageService;

    @MessageMapping("/chat/{roomCode}")
    @SendTo("/topic/{roomCode}")
    public MessageWebSocketDto chat(@DestinationVariable String roomCode, MessageWebSocketDto chatDto) {
        this.messageService.create(chatDto);
        return new MessageWebSocketDto(chatDto.getChat(), chatDto.getUser(), chatDto.getContent());
    }

}
