package com.updown.api.login.presentation;

import com.updown.api.account.domain.AccountEntity;
import com.updown.api.account.domain.value.LoginId;
import com.updown.api.account.infrastructure.repository.AccountEntityRepository;
import com.updown.api.common.exception.CustomRuntimeException;
import com.updown.api.common.exception.ExceptionType;
import com.updown.api.common.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final AccountEntityRepository accountEntityRepository;
    private final JwtProvider jwtProvider;

    @GetMapping
    public String login(@RequestParam String loginId, @RequestParam String password) {
        var accountEntity = accountEntityRepository.findAccountByLoginId(LoginId.of(loginId))
                .orElseThrow(() -> new CustomRuntimeException(ExceptionType.NOT_FOUND_USER));

        if (!accountEntity.getPassword().matches(password)) {
            throw new CustomRuntimeException(ExceptionType.NOT_FOUND_USER);
        }

        return jwtProvider.createToken(accountEntity.getLoginId().getValue());
    }
}
