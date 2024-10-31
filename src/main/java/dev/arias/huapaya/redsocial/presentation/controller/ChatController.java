package dev.arias.huapaya.redsocial.presentation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import dev.arias.huapaya.redsocial.presentation.dto.chat.ChatUpdateDto;
import dev.arias.huapaya.redsocial.service.interfaces.ChatService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping(path = "chat")
@RestController
public class ChatController {

    private final ChatService chatService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ChatCreateDto chat) {
        Map<String, Object> response = new HashMap<>();
        ChatEntity chatCreate = this.chatService.create(chat);
        response.put("data", chatCreate);
        response.put("message", "Successfully created");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<?> update(@RequestBody ChatUpdateDto chat, @PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        ChatEntity chatUpdate = this.chatService.update(chat, id);
        response.put("data", chatUpdate);
        response.put("message", "Successfully updated");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<ChatAllDto> chatAll = this.chatService.findAll();
        return new ResponseEntity<>(chatAll, HttpStatus.OK);
    }

}
