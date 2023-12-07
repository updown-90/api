package com.updown.api.account.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
public record AccountFindResponse(
        String loginId,
        String accountName
) {
}
