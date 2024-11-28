package dev.arias.huapaya.redsocial.service.implementation;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.kevinsawicki.timeago.TimeAgo;

import dev.arias.huapaya.redsocial.persistence.entity.ChatEntity;
import dev.arias.huapaya.redsocial.persistence.repository.ChatRepository;
import dev.arias.huapaya.redsocial.presentation.dto.chat.ChatAllByUserDto;
import dev.arias.huapaya.redsocial.presentation.dto.chat.ChatAllDto;
import dev.arias.huapaya.redsocial.presentation.dto.chat.ChatCreateDto;
import dev.arias.huapaya.redsocial.presentation.dto.chat.ChatOneDto;
import dev.arias.huapaya.redsocial.presentation.dto.chat.ChatUpdateDto;
import dev.arias.huapaya.redsocial.presentation.exception.ChatException;
import dev.arias.huapaya.redsocial.presentation.projection.chat.ChatAllByUserProjection;
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

    @Transactional(readOnly = true)
    @Override
    public List<ChatAllByUserDto> findChatsByUserId(Long userId) {
        List<ChatAllByUserProjection> projections = this.chatRepository.findChatsByUserId(userId);
        List<ChatAllByUserDto> listDto = projections.stream()
                .map(projection -> {
                    LocalDateTime lastMessageTime = projection.getMessage().getCreatedAt();
                    Date messageDate = Date.from(lastMessageTime.atZone(ZoneId.systemDefault()).toInstant());
                    long messageTimestamp = messageDate.getTime();
                    TimeAgo timeAgo = new TimeAgo();
                    String timeAgoString = timeAgo.timeAgo(messageTimestamp);
                    return new ChatAllByUserDto(projection.getChat(), projection.getMessage(), timeAgoString);
                }).collect(Collectors.toList());
        return listDto;
    }

    @Transactional(readOnly = true)
    @Override
    public ChatAllByUserDto findChatOneByUserId(Long chatId, Long userId) {
        ChatAllByUserProjection projection = this.chatRepository.findChatOneByUserId(chatId, userId);
        LocalDateTime lastMessageTime = projection.getMessage().getCreatedAt();
        Date messageDate = Date.from(lastMessageTime.atZone(ZoneId.systemDefault()).toInstant());
        long messageTimestamp = messageDate.getTime();
        TimeAgo timeAgo = new TimeAgo();
        String timeAgoString = timeAgo.timeAgo(messageTimestamp);
        ChatAllByUserDto listDto = new ChatAllByUserDto(projection.getChat(), projection.getMessage(), timeAgoString);
        return listDto;
    }

    @Override
    public List<ChatEntity> findChatNotificationsByUser(Long userId) {
        return this.chatRepository.findChatNotificationsByUser(userId);
    }

}
