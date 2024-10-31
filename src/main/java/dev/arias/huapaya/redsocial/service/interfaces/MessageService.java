package dev.arias.huapaya.redsocial.service.interfaces;

import java.util.List;

import dev.arias.huapaya.redsocial.persistence.entity.MessageEntity;
import dev.arias.huapaya.redsocial.presentation.dto.message.MessageAllDto;
import dev.arias.huapaya.redsocial.presentation.dto.message.MessageCreateDto;
import dev.arias.huapaya.redsocial.presentation.dto.message.MessageUpdateDto;

public interface MessageService {

    public MessageEntity create(MessageCreateDto message);

    public MessageEntity update(MessageUpdateDto message, Long id);

    public List<MessageAllDto> findAll();

}
