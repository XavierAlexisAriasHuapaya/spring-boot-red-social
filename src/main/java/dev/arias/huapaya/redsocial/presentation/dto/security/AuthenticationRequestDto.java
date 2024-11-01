package dev.arias.huapaya.redsocial.presentation.dto.security;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AuthenticationRequestDto implements Serializable{
    
    private String username;

    private String password;

}
