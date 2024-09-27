package com.vti.account_service.controller;

import com.vti.account_service.dto.AccountDto;
import com.vti.account_service.form.AccountCreateForm;
import com.vti.account_service.form.AccountUpdateForm;
import com.vti.account_service.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AccountController {
    private AccountService accountService;
    @PostMapping("/api/v1/accounts/deposit/{id}")
    public AccountDto deposit(@PathVariable("id") Long id, @RequestBody AccountUpdateForm form) {
        return accountService.deposit(id, form);
    }

    @PostMapping("/api/v1/accounts/withdraw/{id}")
    public AccountDto withdraw(@PathVariable("id") Long id, @RequestBody AccountUpdateForm form) {
        return accountService.withdraw(id, form);
    }

    @GetMapping("/api/v1/accounts")
    public Page<AccountDto> findAll(Pageable pageable) {
        return accountService.findAll(pageable);
    }

    @GetMapping("/api/v1/users/{userId}/accounts")
    public Page<AccountDto> findByUserId(@PathVariable("userId") Long userId, Pageable pageable) {
        return accountService.findByUserId(userId, pageable);
    }

    @GetMapping("/api/v1/accounts/{id}")
    public AccountDto findById(@PathVariable("id") Long id) {
        return accountService.findById(id);
    }

    @PostMapping("/api/v1/users/{userId}/accounts")
    public AccountDto create(@PathVariable("userId") Long userId, @RequestBody AccountCreateForm form) {
        return accountService.create(userId, form);
    }

    @PutMapping("/api/v1/accounts/{id}")
    public AccountDto update(@PathVariable("id") Long id, @RequestBody AccountUpdateForm form) {
        return accountService.update(id, form);
    }

    @DeleteMapping("api/v1/accounts/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        accountService.deleteById(id);
    }
}
