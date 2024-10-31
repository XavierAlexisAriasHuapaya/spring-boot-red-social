package dev.arias.huapaya.redsocial.presentation.dto.publication;

import dev.arias.huapaya.redsocial.persistence.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PublicationCreateDto {

    private UserEntity user;

    private String content;

}
