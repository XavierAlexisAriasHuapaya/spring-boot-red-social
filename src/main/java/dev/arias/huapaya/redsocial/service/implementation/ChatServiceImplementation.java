package dev.arias.huapaya.redsocial.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.arias.huapaya.redsocial.persistence.entity.ChatEntity;
import dev.arias.huapaya.redsocial.persistence.repository.ChatRepository;
import dev.arias.huapaya.redsocial.presentation.dto.chat.ChatAllDto;
import dev.arias.huapaya.redsocial.presentation.dto.chat.ChatCreateDto;
import dev.arias.huapaya.redsocial.presentation.dto.chat.ChatOneDto;
import dev.arias.huapaya.redsocial.presentation.dto.chat.ChatUpdateDto;
import dev.arias.huapaya.redsocial.presentation.exception.ChatException;
import dev.arias.huapaya.redsocial.service.interfaces.ChatService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ChatServiceImplementation implements ChatService {

    private final ChatRepository chatRepository;

    @Transactional(readOnly = false)
    @Override
    public ChatEntity create(ChatCreateDto chat) {
        ChatEntity chatCreate = ChatEntity.builder()
                .name(chat.getName())
                .chatType(chat.getChatType())
                .chatMembers(chat.getChatMembers())
                .build();
        return this.chatRepository.save(chatCreate);
    }

    @Transactional(readOnly = false)
    @Override
    public ChatEntity update(ChatUpdateDto chat, Long id) {
        ChatEntity chatFind = this.chatRepository.findById(id).get();
        ChatEntity chatUpdate = ChatEntity.builder()
                .id(id)
                .name(chat.getName())
                .chatType(chatFind.getChatType())
                .createdAt(chatFind.getCreatedAt())
                .updatedAt(chatFind.getUpdatedAt())
                .status(chatFind.getStatus())
                .build();
        return this.chatRepository.save(chatUpdate);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ChatAllDto> findAll() {
        List<ChatEntity> findAll = this.chatRepository.findAll();
        return findAll.stream()
                .map(this::convertAll)
                .collect(Collectors.toList());
    }

    private ChatAllDto convertAll(ChatEntity chat) {
        ChatAllDto chatAllDto = ChatAllDto.builder()
                .id(chat.getId())
                .name(chat.getName())
                .chatType(chat.getChatType())
                .chatMembers(chat.getChatMembers())
                .createdAt(chat.getCreatedAt())
                .updatedAt(chat.getUpdatedAt())
                .status(chat.getStatus())
                .build();
        return chatAllDto;
    }

    private ChatOneDto convertOne(ChatEntity chat) {
        ChatOneDto chatOneDto = ChatOneDto.builder()
                .id(chat.getId())
                .roomCode(chat.getRoomCode())
                .name(chat.getName())
                .chatType(chat.getChatType())
                .createdAt(chat.getCreatedAt())
                .updatedAt(chat.getUpdatedAt())
                .status(chat.getStatus())
                .build();
        return chatOneDto;
    }

    @Override
    public ChatOneDto getChatByUsers(Long userOne, Long userTwo) {
        Optional<ChatEntity> chat = this.chatRepository.getChatByUsers(userOne, userTwo);
        if (!chat.isPresent()) {
            throw new ChatException("Record Empty");
        }
        return this.convertOne(chat.get());
    }

}
