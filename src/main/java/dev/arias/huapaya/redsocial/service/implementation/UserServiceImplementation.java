package dev.arias.huapaya.redsocial.service.implementation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.arias.huapaya.redsocial.persistence.entity.UserEntity;
import dev.arias.huapaya.redsocial.persistence.repository.UserRepository;
import dev.arias.huapaya.redsocial.presentation.dto.users.UserCreateDto;
import dev.arias.huapaya.redsocial.presentation.dto.users.UserPaginationDto;
import dev.arias.huapaya.redsocial.presentation.dto.users.UserUpdateDto;
import dev.arias.huapaya.redsocial.service.interfaces.UserService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = false)
    @Override
    public UserEntity create(UserCreateDto user) {
        UserEntity userCreate = UserEntity.builder().username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .build();
        return this.userRepository.save(userCreate);
    }

    @Transactional(readOnly = false)
    @Override
    public UserEntity update(UserUpdateDto user, Long id) {
        UserEntity userUpdate = UserEntity.builder()
                .password(user.getPassword())
                .build();
        return this.userRepository.save(userUpdate);
    }

    @Transactional(readOnly = true)
    @Override
    public UserEntity findOne(Long id) {
        return this.userRepository.findById(id).get();
    }

    @Transactional(readOnly = true)
    @Override
    public Page<UserPaginationDto> pagination(Pageable pageable) {
        Page<UserEntity> page = this.userRepository.findAll(pageable);
        return page.map(this::convertPagination);
    }

    private UserPaginationDto convertPagination(UserEntity user) {
        UserPaginationDto paginationDto = UserPaginationDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .status(user.getStatus())
                .build();
        return paginationDto;
    }

}
