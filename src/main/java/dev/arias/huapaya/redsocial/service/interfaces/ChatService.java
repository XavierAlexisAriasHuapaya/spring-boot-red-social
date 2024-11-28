package dev.arias.huapaya.redsocial.service.interfaces;

import java.util.List;

import dev.arias.huapaya.redsocial.persistence.entity.ChatEntity;
import dev.arias.huapaya.redsocial.presentation.dto.chat.ChatAllByUserDto;
import dev.arias.huapaya.redsocial.presentation.dto.chat.ChatAllDto;
import dev.arias.huapaya.redsocial.presentation.dto.chat.ChatCreateDto;
import dev.arias.huapaya.redsocial.presentation.dto.chat.ChatOneDto;
import dev.arias.huapaya.redsocial.presentation.dto.chat.ChatUpdateDto;

public interface ChatService {

    public ChatEntity create(ChatCreateDto chat);

    public ChatEntity update(ChatUpdateDto chat, Long id);

    public List<ChatAllDto> findAll();

    public ChatOneDto getChatByUsers(Long userOne, Long userTwo);

    List<ChatAllByUserDto> findChatsByUserId(Long userId);

    ChatAllByUserDto findChatOneByUserId(Long chatId, Long userId);

    List<ChatEntity> findChatNotificationsByUser(Long userId);

}
