package dev.arias.huapaya.redsocial.presentation.dto.message;

import java.time.LocalDateTime;

import dev.arias.huapaya.redsocial.persistence.entity.ChatEntity;
import dev.arias.huapaya.redsocial.persistence.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MessageAllDto {

    private Long id;

    private ChatEntity chat;

    private UserEntity user;

    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
