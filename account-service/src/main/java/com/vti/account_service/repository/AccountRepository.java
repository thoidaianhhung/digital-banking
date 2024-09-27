package com.vti.account_service.repository;

import com.vti.account_service.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcccountRepository extends JpaRepository<Account, Long> {
}
