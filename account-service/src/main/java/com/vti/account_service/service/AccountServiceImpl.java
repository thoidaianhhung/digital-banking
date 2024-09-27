package com.vti.account_service.service;

import com.vti.account_service.dto.AccountDto;
import com.vti.account_service.form.AccountCreateForm;
import com.vti.account_service.form.AccountUpdateForm;
import com.vti.account_service.mapper.AccountMapper;
import com.vti.account_service.repository.AccountRepository;
import com.vti.account_service.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{

    private AccountRepository accountRepository;
    private UserRepository userRepository;

    @Override
    public AccountDto deposit(Long id, AccountUpdateForm form) {
        var optional = accountRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        var account = optional.get();
        account.setBalance(account.getBalance() + form.getBalance());
        var saveAccount = accountRepository.save(account);
        return AccountMapper.map(saveAccount);
    }

    @Override
    @Transactional
    public AccountDto withdraw(Long id, AccountUpdateForm form) {
        var optional = accountRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        var account = optional.get();
        if (account.getBalance() < form.getBalance()) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        account.setBalance(account.getBalance() - form.getBalance());
        var saveAccount = accountRepository.save(account);
        return AccountMapper.map(saveAccount);
    }
    @Override
    public Page<AccountDto> findAll(Pageable pageable) {
        return accountRepository.findAll(pageable)
                .map(AccountMapper::map);
    }

    @Override
    public Page<AccountDto> findByUserId(Long userId, Pageable pageable) {
        return accountRepository.findByUserId(userId, pageable);
    }

    @Override
    public AccountDto findById(Long id) {
        return accountRepository.findById(id)
                .map((AccountMapper::map))
                .orElse(null);
    }

    @Override
    public AccountDto create(Long userId, AccountCreateForm form) {
        var optional = userRepository.findById(userId);
        if (optional.isEmpty()) {
            return null;
        }
        var user = optional.get();
        var account = AccountMapper.map(form);
        account.setUser(user);
        var saveAccount = accountRepository.save(account);
        return AccountMapper.map(saveAccount);
    }

    @Override
    public AccountDto update(Long id, AccountUpdateForm form) {
        var optional = accountRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        var account = optional.get();
        AccountMapper.map(form, account);
        var saveAccount = accountRepository.save(account);
        return AccountMapper.map(saveAccount);
    }

    @Override
    public void deleteById(Long id) {
        accountRepository.deleteById(id);
    }
}
