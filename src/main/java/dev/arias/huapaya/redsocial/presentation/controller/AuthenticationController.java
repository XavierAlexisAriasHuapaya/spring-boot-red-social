package dev.arias.huapaya.redsocial.presentation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.arias.huapaya.redsocial.presentation.dto.security.AuthenticationRequestDto;
import dev.arias.huapaya.redsocial.presentation.dto.security.AuthenticationResponseDto;
import dev.arias.huapaya.redsocial.service.interfaces.JwtService;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@RequestMapping(path = "auth")
@RestController
public class AuthenticationController {

    private final JwtService jwtService;

    @PreAuthorize("permitAll()")
    @PostMapping(path = "authenticate")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequestDto request) {
        AuthenticationResponseDto response = this.jwtService.login(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PreAuthorize("permitAll()")
    @PostMapping(path = "validate")
    public ResponseEntity<?> login(@RequestParam String token) {
        Map<String, Object> response = new HashMap<>();
        response = this.jwtService.validate(token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
