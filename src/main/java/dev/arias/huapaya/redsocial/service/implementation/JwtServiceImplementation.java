package dev.arias.huapaya.redsocial.service.implementation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.arias.huapaya.redsocial.persistence.entity.UserEntity;
import dev.arias.huapaya.redsocial.persistence.repository.UserRepository;
import dev.arias.huapaya.redsocial.presentation.dto.security.AuthenticationRequestDto;
import dev.arias.huapaya.redsocial.presentation.dto.security.AuthenticationResponseDto;
import dev.arias.huapaya.redsocial.presentation.exception.ObjectNotFoundException;
import dev.arias.huapaya.redsocial.service.interfaces.JwtService;
import dev.arias.huapaya.redsocial.util.JwtUtil;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class JwtServiceImplementation implements JwtService {

    private final UserRepository userRepository;

    private final JwtUtil jwtUtil;

    private final AuthenticationManager authenticationManager;

    @Transactional(readOnly = true)
    @Override
    public AuthenticationResponseDto login(AuthenticationRequestDto request) {
        String username = request.getUsername();
        String password = request.getPassword();
        UserEntity userFind = this.userRepository.findByUsername(username)
                .orElseThrow(() -> new ObjectNotFoundException("user not found: " + username));
        Authentication authentication = new UsernamePasswordAuthenticationToken(username,
                password);
        authenticationManager.authenticate(authentication);
        String jwt = this.jwtUtil.generateToken(userFind, this.extraClaims(userFind));
        AuthenticationResponseDto response = AuthenticationResponseDto.builder()
                .jwt(jwt)
                .username(username)
                .build();
        return response;
    }

    private Map<String, Object> extraClaims(UserEntity user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("authorities", user.getAuthorities());
        return claims;
    }

    @Override
    public Map<String, Object> validate(String token) {
        Map<String, Object> response = new HashMap<>();
        try {
            this.jwtUtil.extractUsername(token);
            response.put("message", "valid");
        } catch (Exception e) {
            response.put("message", "Invalid");
        }
        return response;
    }

}
