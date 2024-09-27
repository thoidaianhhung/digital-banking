package com.vti.transaction_service.mapper;

import com.vti.transaction_service.dto.TransactionDto;
import com.vti.transaction_service.entity.Transaction;
import com.vti.transaction_service.form.TransactionCreateForm;

public class TransactionMapper {
    public static Transaction map(TransactionCreateForm form) {
        var transaction = new Transaction();
        transaction.setFromAccount(form.getFromAccount());
        transaction.setToAccount(form.getToAccount());
        transaction.setAmount(form.getAmount());
        return transaction;
    }

    public static TransactionDto map(Transaction transaction) {
        var dto = new TransactionDto();
        dto.setId(transaction.getId());
        dto.setFromAccountId(transaction.getFromAccount());
        dto.setToAccountId(transaction.getToAccount());
        dto.setAmount(transaction.getAmount());
        return dto;
    }
}
