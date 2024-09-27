package com.vti.transaction_service.mapper;

import com.vti.transaction_service.dto.AccountDto;
import com.vti.transaction_service.entity.Account;
import com.vti.transaction_service.form.AccountUpdateForm;

public class AccountMapper {

    private AccountMapper() {
        throw new IllegalStateException("Utility class");
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
