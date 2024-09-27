package com.vti.user_service.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {
    private String name;

    private String email;

    private String phone;
}
