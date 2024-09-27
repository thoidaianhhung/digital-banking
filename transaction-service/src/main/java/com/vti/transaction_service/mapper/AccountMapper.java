package com.vti.account_service.mapper;

import com.vti.account_service.dto.AccountDto;
import com.vti.account_service.entity.Account;
import com.vti.account_service.form.AccountCreateForm;
import com.vti.account_service.form.AccountUpdateForm;

public class AccountMapper {

    private AccountMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static Account map(AccountCreateForm form) {
        var account = new Account();
        account.setBalance(form.getBalance());
        return account;
    }

    public static AccountDto map(Account account) {
        var dto = new AccountDto();
        dto.setId(account.getId());
        dto.setBalance(account.getBalance());
        return dto;
    }

    public static void map(AccountUpdateForm form, Account account) {
        account.setBalance(form.getBalance());
    }
}
