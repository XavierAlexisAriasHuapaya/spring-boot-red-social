package dev.arias.huapaya.redsocial.presentation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.arias.huapaya.redsocial.persistence.entity.ChatEntity;
import dev.arias.huapaya.redsocial.presentation.dto.chat.ChatAllDto;
import dev.arias.huapaya.redsocial.presentation.dto.chat.ChatCreateDto;
import dev.arias.huapaya.redsocial.presentation.dto.chat.ChatOneDto;
import dev.arias.huapaya.redsocial.presentation.dto.chat.ChatUpdateDto;
import dev.arias.huapaya.redsocial.presentation.exception.ChatException;
import dev.arias.huapaya.redsocial.service.interfaces.ChatService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping(path = "chat")
@RestController
public class ChatController {

    private final ChatService chatService;

    @PreAuthorize("hasAuthority('CHAT_CREATE')")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ChatCreateDto chat) {
        Map<String, Object> response = new HashMap<>();
        ChatEntity chatCreate = this.chatService.create(chat);
        response.put("data", chatCreate);
        response.put("message", "Successfully created");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('CHAT_UPDATE')")
    @PutMapping(path = "{id}")
    public ResponseEntity<?> update(@RequestBody ChatUpdateDto chat, @PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        ChatEntity chatUpdate = this.chatService.update(chat, id);
        response.put("data", chatUpdate);
        response.put("message", "Successfully updated");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('CHAT_ALL')")
    @GetMapping
    public ResponseEntity<?> findAll() {
        List<ChatAllDto> chatAll = this.chatService.findAll();
        return new ResponseEntity<>(chatAll, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('CHAT_BY_USERS')")
    @GetMapping(path = "users/one/{userIdOne}/two/{userIdTwo}")
    public ResponseEntity<?> getChatByUsers(@PathVariable Long userIdOne, @PathVariable Long userIdTwo) {
        try {
            ChatOneDto chat = this.chatService.getChatByUsers(userIdOne, userIdTwo);
            return new ResponseEntity<>(chat, HttpStatus.OK);
        } catch (ChatException e) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

}
