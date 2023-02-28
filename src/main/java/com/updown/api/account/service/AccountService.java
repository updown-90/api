package com.updown.api.account.service;

import com.updown.api.account.domain.Account;
import com.updown.api.account.domain.Role;
import com.updown.api.account.infrastructure.dto.AccountEntityQueryDSLDTO;
import com.updown.api.account.infrastructure.repository.AccountEntityRepository;
import com.updown.api.account.infrastructure.repository.RoleEntityRepository;
import com.updown.api.account.presentation.dto.request.AccountSaveRequestDTO;
import com.updown.api.account.presentation.dto.request.AccountUpdateRequestDTO;
import com.updown.api.account.presentation.dto.request.AccountsFindRequestDTO;
import com.updown.api.common.exception.CustomRuntimeException;
import com.updown.api.common.exception.ExceptionType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountEntityRepository accountEntityRepository;
    private final RoleEntityRepository roleEntityRepository;

    public Account createAccount(AccountSaveRequestDTO accountSaveRequestDTO) {
        Role role = roleEntityRepository.findByRoleType(Role.DEFAULT_ROLE_TYPE);

        return isEmptyDBLoginId(accountSaveRequestDTO) ?
                accountEntityRepository.save(Account.create(accountSaveRequestDTO, role)) : null;
    }

    public Account findAccountById(Long id) {
        return accountEntityRepository.findAccountById(id)
                .orElseThrow(() -> new CustomRuntimeException(ExceptionType.NOT_FOUND_USER));
    }

    public List<AccountEntityQueryDSLDTO> findAccounts(AccountsFindRequestDTO accountsFindRequestDTO) {
        return accountEntityRepository.findAccounts(accountsFindRequestDTO);
    }

    public Account updateAccount(AccountUpdateRequestDTO accountUpdateRequestDTO) {
        Account account = accountEntityRepository.findById(accountUpdateRequestDTO.getId())
                .orElseThrow(() -> new CustomRuntimeException(ExceptionType.NOT_FOUND_USER));

        account.update(accountUpdateRequestDTO);
        return accountEntityRepository.save(account);
    }

    public void deleteAccount(Long id) {
        accountEntityRepository.deleteById(id);
    }

    private boolean isEmptyDBLoginId(AccountSaveRequestDTO accountSaveRequestDTO) {
        accountEntityRepository.findAccountByLoginId(accountSaveRequestDTO.getLoginId())
                .ifPresent(accountEntity -> {   // ifPresent()는 Optional 객체가 값을 가지고 있으면 실행 값이 없으면 넘어감
                    throw new CustomRuntimeException(ExceptionType.NOT_FOUND_USER);
                });

        return true;
    }

    public Account creatAccont() {
        return null;
    }
}
