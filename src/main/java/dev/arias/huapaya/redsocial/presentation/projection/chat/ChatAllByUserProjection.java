package dev.arias.huapaya.redsocial.presentation.projection.chat;

import dev.arias.huapaya.redsocial.persistence.entity.ChatEntity;
import dev.arias.huapaya.redsocial.persistence.entity.MessageEntity;

public interface ChatAllByUserProjection {

    ChatEntity getChat();

    MessageEntity getMessage();

    String getMessageTime();

}
