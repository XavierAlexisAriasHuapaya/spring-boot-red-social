package dev.arias.huapaya.redsocial.presentation.dto.publication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PublicationUpdateDto {
    
    private Long id;

    private String content;
    
}
