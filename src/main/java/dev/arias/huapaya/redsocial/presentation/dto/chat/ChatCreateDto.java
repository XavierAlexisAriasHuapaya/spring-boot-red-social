package dev.arias.huapaya.redsocial.presentation.dto.chat;

import java.util.List;

import dev.arias.huapaya.redsocial.persistence.entity.ChatMemberEntity;
import dev.arias.huapaya.redsocial.persistence.entity.enums.ChatTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChatCreateDto {

    private String name;

    private ChatTypeEnum chatType;

    private List<ChatMemberEntity> chatMembers;

}
