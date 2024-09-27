package com.vti.user_service.service;

import com.vti.user_service.dto.UserDto;
import com.vti.user_service.form.UserCreateForm;
import com.vti.user_service.form.UserUpdateForm;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto findById(Long id);
    UserDto create(UserCreateForm form);

    UserDto update(UserUpdateForm form, Long id);

    void deleteById(Long id);
}
