package com.vti.user_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long id;

    private String name;

    private String email;

    private String phone;
}
