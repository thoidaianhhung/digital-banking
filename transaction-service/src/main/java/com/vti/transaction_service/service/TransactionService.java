package com.vti.transaction_service.service;

import com.vti.transaction_service.dto.TransactionDto;
import com.vti.transaction_service.form.TransactionCreateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransactionService {
    Page<TransactionDto> findByAccountId(Long accountId, Pageable pageable);

    void transferMoney(TransactionCreateForm form);

    void deleteById(Long id);
}
