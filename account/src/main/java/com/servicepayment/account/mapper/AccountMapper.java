package com.servicepayment.account.mapper;

import com.servicepayment.account.dto.AccountDTO;
import com.servicepayment.account.entity.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    Account toEntity (AccountDTO accountDTO);
    AccountDTO toDTO(Account account);
}
