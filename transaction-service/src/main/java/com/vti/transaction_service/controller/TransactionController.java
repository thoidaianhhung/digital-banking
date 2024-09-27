package com.vti.transaction_service.controller;

import com.vti.transaction_service.dto.TransactionDto;
import com.vti.transaction_service.form.TransactionCreateForm;
import com.vti.transaction_service.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class TransactionController {
    private TransactionService transactionService;

    @PostMapping("/api/v1/accounts/{accountId}/transactions")
    public Page<TransactionDto> findByAccountId(@PathVariable("accountId") Long accountId, Pageable pageable) {
        return transactionService.findByAccountId(accountId, pageable);
    }


    @PostMapping("/api/v1/transactions/transfer")
    public void transferMoney(@RequestBody TransactionCreateForm form) {
        transactionService.transferMoney(form);
    }

    @DeleteMapping("/api/v1/transactions/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        transactionService.deleteById(id);
    }
}
