package com.vti.account_service.dto;

import com.vti.account_service.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDto {
    private Long id;

    private Double balance;
}
