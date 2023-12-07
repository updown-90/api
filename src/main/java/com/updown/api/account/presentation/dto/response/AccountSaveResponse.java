package com.updown.api.account.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

// @Builder 있어야 MapStruct 값 매핑 동작 가능
@Builder
public record AccountSaveResponse(
        String loginId,
        String accountName
) {
}
