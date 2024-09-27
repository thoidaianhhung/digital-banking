package com.vti.user_service.mapper;

import com.vti.user_service.dto.UserDto;
import com.vti.user_service.entity.User;
import com.vti.user_service.form.UserCreateForm;
import com.vti.user_service.form.UserUpdateForm;

public class UserMapper {
    public static User map(UserCreateForm form) {
        var user = new User();
        user.setName(form.getName());
        user.setEmail(form.getEmail());
        user.setPhone(form.getPhone());
        return user;
    }

    public static UserDto map(User user) {
        var dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        return dto;
    }

    public static void map(UserUpdateForm form, User user) {
        user.setName(form.getName());
        user.setEmail(form.getEmail());
        user.setPhone(form.getPhone());
    }
}
