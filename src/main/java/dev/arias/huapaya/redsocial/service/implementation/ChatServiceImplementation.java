package dev.arias.huapaya.redsocial.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.arias.huapaya.redsocial.persistence.entity.ChatEntity;
import dev.arias.huapaya.redsocial.persistence.repository.ChatRepository;
import dev.arias.huapaya.redsocial.presentation.dto.chat.ChatAllDto;
import dev.arias.huapaya.redsocial.presentation.dto.chat.ChatCreateDto;
import dev.arias.huapaya.redsocial.presentation.dto.chat.ChatUpdateDto;
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
                .build();
        return this.chatRepository.save(chatCreate);
    }

    @Transactional(readOnly = false)
    @Override
    public ChatEntity update(ChatUpdateDto chat, Long id) {
        ChatEntity chatUpdate = ChatEntity.builder()
                .id(id)
                .name(chat.getName())
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
                .createdAt(chat.getCreatedAt())
                .updatedAt(chat.getUpdatedAt())
                .status(chat.getStatus())
                .build();
        return chatAllDto;
    }

}
