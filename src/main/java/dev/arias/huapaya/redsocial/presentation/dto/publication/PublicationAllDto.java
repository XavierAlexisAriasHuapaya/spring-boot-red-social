package dev.arias.huapaya.redsocial.presentation.dto.publication;

import java.time.LocalDateTime;

import dev.arias.huapaya.redsocial.persistence.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PublicationAllDto {

    private Long id;

    private UserEntity user;

    private String content;

    private LocalDateTime createdAt;

}
