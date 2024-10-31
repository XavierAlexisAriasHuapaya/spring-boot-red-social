package dev.arias.huapaya.redsocial.presentation.dto.chat;

import java.time.LocalDateTime;

import dev.arias.huapaya.redsocial.persistence.entity.enums.ChatTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChatAllDto {

    private Long id;

    private String name;

    private ChatTypeEnum chatType;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Boolean status;

}
