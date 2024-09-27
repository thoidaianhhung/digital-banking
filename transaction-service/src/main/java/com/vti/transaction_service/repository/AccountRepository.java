package com.vti.account_service.repository;

import com.vti.account_service.dto.AccountDto;
import com.vti.account_service.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Page<AccountDto> findByUserId(@Param("userId") Long userId, Pageable pageable);
}
