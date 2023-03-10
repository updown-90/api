package com.updown.api.account.presentation.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class AccountUpdateRequestDTO {

    @NotEmpty
    private Long id;

    @NotEmpty
    private String changeAccountName;

}
