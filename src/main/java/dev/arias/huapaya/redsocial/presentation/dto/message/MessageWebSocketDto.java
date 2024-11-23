package dev.arias.huapaya.redsocial.presentation.dto.message;

import dev.arias.huapaya.redsocial.persistence.entity.ChatEntity;
import dev.arias.huapaya.redsocial.persistence.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageWebSocketDto {

    public ChatEntity chat;
    public UserEntity user;
    public String content;

}
