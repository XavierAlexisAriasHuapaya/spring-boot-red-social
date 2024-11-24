package dev.arias.huapaya.redsocial.presentation.dto.users;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserPaginationDto {

    private Long id;

    private String username;

    private String email;

    private String name;

    private String lastName;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Boolean status;

}
