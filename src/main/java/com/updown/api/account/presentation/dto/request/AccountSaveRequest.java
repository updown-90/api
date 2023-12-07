package com.updown.api.account.presentation.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record AccountSaveRequest(
        @NotEmpty String loginId,
        @NotEmpty String password,
        @NotEmpty String accountName,
        @NotNull Long departmentId
) {
//    public static AccountSaveRequest of(Object entity) {
//        return new AccountSaveRequest(
//                entity.getLoginId(),
//                entity.getPassword(),
//                entity.getAccountName(),
//                entity.getDepartmentId()
//        );
//    }
}
