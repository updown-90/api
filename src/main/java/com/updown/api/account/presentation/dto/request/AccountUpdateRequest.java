package com.updown.api.account.presentation.dto.request;

import javax.validation.constraints.NotEmpty;

public record AccountUpdateRequest(
        @NotEmpty Long id,
        @NotEmpty String changeAccountName
) {
}
