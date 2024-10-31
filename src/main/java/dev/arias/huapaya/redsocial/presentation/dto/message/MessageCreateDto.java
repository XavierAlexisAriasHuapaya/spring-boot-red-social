package dev.arias.huapaya.redsocial.presentation.dto.message;

import dev.arias.huapaya.redsocial.persistence.entity.ChatEntity;
import dev.arias.huapaya.redsocial.persistence.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MessageCreateDto {

    private ChatEntity chat;

    private UserEntity user;

    private String content;

}
