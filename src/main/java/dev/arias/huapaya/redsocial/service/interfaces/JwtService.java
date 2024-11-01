package dev.arias.huapaya.redsocial.service.interfaces;

import java.util.Map;

import dev.arias.huapaya.redsocial.presentation.dto.security.AuthenticationRequestDto;
import dev.arias.huapaya.redsocial.presentation.dto.security.AuthenticationResponseDto;

public interface JwtService {

    public AuthenticationResponseDto login(AuthenticationRequestDto request);

    public Map<String, Object> validate(String token);

}
