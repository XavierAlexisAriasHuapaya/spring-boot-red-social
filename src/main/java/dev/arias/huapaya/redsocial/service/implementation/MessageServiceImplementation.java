package dev.arias.huapaya.redsocial.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.arias.huapaya.redsocial.persistence.entity.MessageEntity;
import dev.arias.huapaya.redsocial.persistence.repository.MessageRepository;
import dev.arias.huapaya.redsocial.presentation.dto.message.MessageAllDto;
import dev.arias.huapaya.redsocial.presentation.dto.message.MessageUpdateDto;
import dev.arias.huapaya.redsocial.presentation.dto.message.MessageWebSocketDto;
import dev.arias.huapaya.redsocial.service.interfaces.MessageService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MessageServiceImplementation implements MessageService {

    private final MessageRepository messageRepository;

    @Transactional(readOnly = false)
    @Override
    public MessageEntity create(MessageWebSocketDto message) {
        MessageEntity messageCreate = MessageEntity.builder()
                .chat(message.getChat())
                .user(message.getUser())
                .content(message.getContent())
                .build();
        return this.messageRepository.save(messageCreate);
    }

    @Transactional(readOnly = false)
    @Override
    public MessageEntity update(MessageUpdateDto message, Long id) {
        MessageEntity messageFind = this.messageRepository.findById(id).get();
        MessageEntity messageUpdate = MessageEntity.builder()
                .id(id)
                .chat(messageFind.getChat())
                .user(messageFind.getUser())
                .content(message.getContent())
                .createdAt(messageFind.getCreatedAt())
                .updatedAt(messageFind.getUpdatedAt())
                .status(messageFind.getStatus())
                .build();
        return this.messageRepository.save(messageUpdate);
    }

    @Transactional(readOnly = true)
    @Override
    public List<MessageAllDto> findAll() {
        List<MessageEntity> findAll = this.messageRepository.findAll();
        return findAll.stream()
                .map(this::convertAll)
                .collect(Collectors.toList());
    }

    private MessageAllDto convertAll(MessageEntity message) {
        MessageAllDto messageAllDto = MessageAllDto.builder()
                .id(message.getId())
                .chat(message.getChat())
                .user(message.getUser())
                .content(message.getContent())
                .createdAt(message.getCreatedAt())
                .updatedAt(message.getUpdatedAt())
                .build();
        return messageAllDto;
    }

    @Override
    public List<MessageEntity> findByChatId(Long chatId) {
        List<MessageEntity> findByChatId = this.messageRepository.findByChatId(chatId);
        return findByChatId;
    }

    @Override
    public List<MessageEntity> findByChatRoomCode(String roomCode) {
        return this.messageRepository.findByChatRoomCode(roomCode);
    }

}
