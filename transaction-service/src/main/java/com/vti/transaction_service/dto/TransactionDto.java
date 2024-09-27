package com.vti.transaction_service.dto;

import com.vti.transaction_service.entity.Account;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDto {
    private Long id;

    private Account fromAccountId;

    private Account toAccountId;

    private Double amount;
}
