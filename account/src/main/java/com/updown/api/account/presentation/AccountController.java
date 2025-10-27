package com.updown.api.account.presentation;

import com.updown.api.account.domain.AccountEntity;
import com.updown.api.account.application.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // @ResponseBody 알아서 사용하게 해주려고 사용
@RequiredArgsConstructor // @RequiredArgsConstructor는 초기화 되지않은 final 필드나, @NonNull 이 붙은 필드에 대해 생성자를 생성해 줍니다.
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

//    @ResponseStatus(HttpStatus.CREATED)
//    @Logger 해당 어노테이션이 있으면 AOP 동작하도록 개발되어 있음
    @PostMapping
    public AccountEntity createAccount(@RequestBody @Valid AccountCreateRequest request) {
        return accountService.createAccount(
                request.getLoginId(),
                request.getAccountName(),
                request.getPassword(),
                request.getDepartmentId()
        );
    }

    @GetMapping
    public List<AccountEntity> findAccounts() {
        return accountService.findAccounts();
    }

    @GetMapping("/{id}")
    public AccountEntity findAccountById(@PathVariable Long id) {
        return accountService.findAccountById(id);
    }

    @PutMapping("/{id}")
    public AccountEntity updateAccount(@PathVariable Long id, @RequestBody AccountUpdateRequest request) {
        return accountService.updateAccount(id, request.getChangeAccountName());
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }

    // DTO 클래스들
    public static class AccountCreateRequest {
        private String loginId;
        private String accountName;
        private String password;
        private Long departmentId;

        // Getters and Setters
        public String getLoginId() { return loginId; }
        public void setLoginId(String loginId) { this.loginId = loginId; }
        public String getAccountName() { return accountName; }
        public void setAccountName(String accountName) { this.accountName = accountName; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
        public Long getDepartmentId() { return departmentId; }
        public void setDepartmentId(Long departmentId) { this.departmentId = departmentId; }
    }

    public static class AccountUpdateRequest {
        private String changeAccountName;

        public String getChangeAccountName() { return changeAccountName; }
        public void setChangeAccountName(String changeAccountName) { this.changeAccountName = changeAccountName; }
    }
}
