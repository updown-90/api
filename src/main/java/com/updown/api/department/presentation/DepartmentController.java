package com.updown.api.department.presentation;

import com.updown.api.department.presentation.dto.request.DepartmentSaveRequestDTO;
import com.updown.api.department.presentation.dto.response.DepartmentFindResponseDTO;
import com.updown.api.department.presentation.mapstruct.mapper.DepartmentEntityMapper;
import com.updown.api.department.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController // @ResponseBody 알아서 사용하게 해주려고 사용
@RequiredArgsConstructor // @RequiredArgsConstructor는 초기화 되지않은 final 필드나, @NonNull 이 붙은 필드에 대해 생성자를 생성해 줍니다.
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public DepartmentFindResponseDTO createDepartment(@RequestBody @Valid DepartmentSaveRequestDTO departmentSaveRequestDTO) {
        return DepartmentEntityMapper.INSTANCE.departmentEntityToDepartmentFindResponseDTO(
            departmentService.createDepartment(departmentSaveRequestDTO)
        );
    }

    @GetMapping
    public List<DepartmentFindResponseDTO> findAccounts() {
        return DepartmentEntityMapper.INSTANCE.departmentEntityToDepartmentFindResponseDTO(
                departmentService.findAll()
        );
    }

}