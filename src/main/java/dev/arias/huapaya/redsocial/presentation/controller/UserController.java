package dev.arias.huapaya.redsocial.presentation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.arias.huapaya.redsocial.persistence.entity.UserEntity;
import dev.arias.huapaya.redsocial.presentation.dto.users.UserCreateDto;
import dev.arias.huapaya.redsocial.presentation.dto.users.UserPaginationDto;
import dev.arias.huapaya.redsocial.presentation.dto.users.UserUpdateDto;
import dev.arias.huapaya.redsocial.service.interfaces.UserService;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@RequestMapping(path = "user")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserCreateDto user) {
        Map<String, Object> response = new HashMap<>();
        UserEntity userCreate = this.userService.create(user);
        response.put("data", userCreate);
        response.put("message", "Successfully created");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<?> update(@RequestBody UserUpdateDto user, @PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        UserEntity userUpdate = this.userService.update(user, id);
        response.put("data", userUpdate);
        response.put("message", "Successfully updated");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> findOne(@PathVariable Long id) {
        UserEntity user = this.userService.findOne(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> pagination(Pageable pageable) {
        Page<UserPaginationDto> userPagination = this.userService.pagination(pageable);
        return new ResponseEntity<>(userPagination, HttpStatus.OK);
    }

}
