package com.vti.user_service.controller;

import com.vti.user_service.dto.UserDto;
import com.vti.user_service.form.UserCreateForm;
import com.vti.user_service.form.UserUpdateForm;
import com.vti.user_service.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {
    private UserService service;

    @GetMapping("/api/v1/users")
    public List<UserDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/api/v1/users/{id}")
    public UserDto findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping("/api/v1/users")
    public UserDto create(@RequestBody UserCreateForm form) {
        return service.create(form);
    }

    @PutMapping("/api/v1/users/{id}")
    public UserDto update(
            @RequestBody UserUpdateForm form,
            @PathVariable("id") Long id) {
        return service.update(form, id);
    }

    @DeleteMapping("/api/v1/users/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
    }
}
