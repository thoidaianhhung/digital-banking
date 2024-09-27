package com.vti.transaction_service.service;

import com.vti.transaction_service.dto.TransactionDto;
import com.vti.transaction_service.entity.Transaction;
import com.vti.transaction_service.form.TransactionCreateForm;
import com.vti.transaction_service.mapper.AccountMapper;
import com.vti.transaction_service.mapper.TransactionMapper;
import com.vti.transaction_service.repository.AccountRepository;
import com.vti.transaction_service.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService{
    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;
    @Override
    public Page<TransactionDto> findByAccountId(Long accountId, Pageable pageable) {
        return transactionRepository.findByFromAccountId(accountId, pageable);
    }

    @Override
    @Transactional
    public void transferMoney(TransactionCreateForm form) {
        var fromOptional = accountRepository.findById(form.getFromAccount().getId());
        if (fromOptional.isEmpty()) {
            throw new IllegalArgumentException("Account not found");
        }
        var toOptional = accountRepository.findById(form.getToAccount().getId());
        if (toOptional.isEmpty()) {
            throw new IllegalArgumentException("Account not found");
        }
        var fromAccount = fromOptional.get();
        if (fromAccount.getBalance() < form.getAmount()) {
            throw new IllegalArgumentException("Insufficient balance in source account");
        }
        fromAccount.setBalance(fromAccount.getBalance() - form.getAmount());
        var saveFromAccount = accountRepository.save(fromAccount);
        AccountMapper.map(saveFromAccount);
        var toAccount = toOptional.get();
        toAccount.setBalance(toAccount.getBalance() + form.getAmount());
        var saveToAccount = accountRepository.save(toAccount);
        AccountMapper.map(saveToAccount);
        var transaction = TransactionMapper.map(form);
        var saveTransaction = transactionRepository.save(transaction);
        TransactionMapper.map(saveTransaction);
    }

    @Override
    public void deleteById(Long id) {
        transactionRepository.deleteById(id);
    }
}
