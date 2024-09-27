package com.vti.transaction_service.repository;

import com.vti.transaction_service.dto.TransactionDto;
import com.vti.transaction_service.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // Tìm các giao dịch dựa trên tài khoản nguồn (fromAccount)
    Page<TransactionDto> findByFromAccountId(Long fromAccountId, Pageable pageable);

    // Tìm các giao dịch dựa trên tài khoản đích (toAccount)
    Page<TransactionDto> findByToAccountId(Long toAccountId, Pageable pageable);
}
