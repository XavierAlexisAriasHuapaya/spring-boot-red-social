package dev.arias.huapaya.redsocial.presentation.dto.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatWebSocketDto {

    public String id;
    public String message;

}
