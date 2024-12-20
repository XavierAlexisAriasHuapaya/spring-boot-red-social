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

import dev.arias.huapaya.redsocial.persistence.entity.MessageEntity;
import dev.arias.huapaya.redsocial.presentation.dto.message.MessageAllDto;
import dev.arias.huapaya.redsocial.presentation.dto.message.MessageCreateDto;
import dev.arias.huapaya.redsocial.presentation.dto.message.MessageUpdateDto;
import dev.arias.huapaya.redsocial.service.interfaces.MessageService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping(path = "message")
@RestController
public class MessageController {

    private final MessageService messageService;

    @PreAuthorize("hasAuthority('MESSAGE_CREATE')")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody MessageCreateDto message) {
        Map<String, Object> response = new HashMap<>();
        // MessageEntity messageCreate = this.messageService.create(message);
        // response.put("data", messageCreate);
        // response.put("message", "Successfully created");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('MESSAGE_UPDATE')")
    @PutMapping(path = "{id}")
    public ResponseEntity<?> update(@RequestBody MessageUpdateDto message, @PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        MessageEntity messageUpdate = this.messageService.update(message, id);
        response.put("data", messageUpdate);
        response.put("message", "Successfully updated");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('MESSAGE_ALL')")
    @GetMapping
    public ResponseEntity<?> findAll() {
        List<MessageAllDto> messageAll = this.messageService.findAll();
        return new ResponseEntity<>(messageAll, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('MESSAGE_BY_CHAT')")
    @GetMapping(path = "chat/{chatId}")
    public ResponseEntity<?> findByChatId(@PathVariable Long chatId) {
        List<MessageEntity> findByChatId = this.messageService.findByChatId(chatId);
        return new ResponseEntity<>(findByChatId, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('MESSAGE_UPDATE_SEEN')")
    @PutMapping(path = "seen/{id}")
    public ResponseEntity<?> updateSeen(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        Boolean flag = this.messageService.updateSeen(id);
        response.put("message", flag ? "Successfully updated" : "Error updated");
        return new ResponseEntity<>(response, flag ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

}
