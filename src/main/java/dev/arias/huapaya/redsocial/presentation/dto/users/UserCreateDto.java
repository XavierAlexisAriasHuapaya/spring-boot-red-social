package dev.arias.huapaya.redsocial.presentation.dto.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCreateDto {

    private String username;

    private String password;

    private String email;

    private String name;

    private String lastName;

}
