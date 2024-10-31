package dev.arias.huapaya.redsocial.service.interfaces;

import java.util.List;

import dev.arias.huapaya.redsocial.persistence.entity.ChatEntity;
import dev.arias.huapaya.redsocial.presentation.dto.chat.ChatAllDto;
import dev.arias.huapaya.redsocial.presentation.dto.chat.ChatCreateDto;
import dev.arias.huapaya.redsocial.presentation.dto.chat.ChatUpdateDto;

public interface ChatService {

    public ChatEntity create(ChatCreateDto chat);

    public ChatEntity update(ChatUpdateDto chat, Long id);

    public List<ChatAllDto> findAll();

}
