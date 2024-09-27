package com.vti.account_service.service;

import com.vti.account_service.dto.AccountDto;
import com.vti.account_service.form.AccountCreateForm;
import com.vti.account_service.form.AccountUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccountService {
    AccountDto deposit(Long id, AccountUpdateForm form);

    AccountDto withdraw(Long id, AccountUpdateForm form);
    Page<AccountDto> findAll(Pageable pageable);

    Page<AccountDto> findByUserId(Long userId, Pageable pageable);

   AccountDto findById(Long id);

    AccountDto create(Long userId, AccountCreateForm form);

    AccountDto update(Long id, AccountUpdateForm form);

    void deleteById(Long id);
}
