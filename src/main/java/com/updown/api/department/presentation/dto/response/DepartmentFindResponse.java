package com.updown.api.department.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DepartmentFindResponse {

    private Long id;

    private String name;

}
