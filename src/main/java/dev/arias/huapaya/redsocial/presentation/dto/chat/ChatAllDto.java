package dev.arias.huapaya.redsocial.presentation.dto.chat;

import java.time.LocalDateTime;
import java.util.List;

import dev.arias.huapaya.redsocial.persistence.entity.ChatMemberEntity;
import dev.arias.huapaya.redsocial.persistence.entity.enums.ChatTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ChatAllDto {

    private Long id;

    private String name;

    private ChatTypeEnum chatType;

    private List<ChatMemberEntity> chatMembers;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Boolean status;

}
