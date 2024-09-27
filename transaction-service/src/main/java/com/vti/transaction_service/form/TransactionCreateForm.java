package com.vti.transaction_service.form;

import com.vti.transaction_service.entity.Account;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionCreateForm {
    private Account fromAccount;
    private Account toAccount;
    private Double amount;
}
