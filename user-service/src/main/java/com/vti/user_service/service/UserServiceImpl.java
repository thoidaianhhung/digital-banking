package com.vti.user_service.service;

import com.vti.user_service.dto.UserDto;
import com.vti.user_service.entity.User;
import com.vti.user_service.form.UserCreateForm;
import com.vti.user_service.form.UserUpdateForm;
import com.vti.user_service.mapper.UserMapper;
import com.vti.user_service.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository repository;
    @Override
    public List<UserDto> findAll() {
        var users = repository.findAll();
        var dtos = new ArrayList<UserDto>();
        for (User user : users) {
            var dto = UserMapper.map(user);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public UserDto findById(Long id) {
        return repository.findById(id)
                .map(UserMapper::map)
                .orElse(null);
    }

    @Override
    public UserDto create(UserCreateForm form) {
        var user = UserMapper.map(form);
        var saveUser = repository.save(user);
        return UserMapper.map(saveUser);
    }

    @Override
    public UserDto update(UserUpdateForm form, Long id) {
        var optional = repository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        var user = optional.get();
        UserMapper.map(form, user);
        var saveUser = repository.save(user);
        return UserMapper.map(saveUser);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
