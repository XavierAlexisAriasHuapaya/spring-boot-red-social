package dev.arias.huapaya.redsocial.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import dev.arias.huapaya.redsocial.persistence.entity.UserEntity;
import dev.arias.huapaya.redsocial.presentation.dto.users.UserCreateDto;
import dev.arias.huapaya.redsocial.presentation.dto.users.UserPaginationDto;
import dev.arias.huapaya.redsocial.presentation.dto.users.UserUpdateDto;

public interface UserService {

    public UserEntity create(UserCreateDto user);

    public UserEntity update(UserUpdateDto user, Long id);

    public UserEntity findOne(Long id);

    public Page<UserPaginationDto> pagination(Pageable pageable);

}
