package com.updown.api.department.presentation;

import com.updown.api.department.domain.DepartmentEntity;
import com.updown.api.department.application.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController // @ResponseBody 알아서 사용하게 해주려고 사용
@RequiredArgsConstructor // @RequiredArgsConstructor는 초기화 되지않은 final 필드나, @NonNull 이 붙은 필드에 대해 생성자를 생성해 줍니다.
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public DepartmentEntity createDepartment(@RequestBody @Valid DepartmentCreateRequest request) {
        return departmentService.createDepartment(request.getName());
    }

    @GetMapping
    public List<DepartmentEntity> findDepartments() {
        return departmentService.findAll();
    }

    @GetMapping("/{id}")
    public DepartmentEntity findDepartmentById(@PathVariable Long id) {
        return departmentService.findById(id);
    }

    @PutMapping("/{id}")
    public DepartmentEntity updateDepartment(@PathVariable Long id, @Valid @RequestBody DepartmentUpdateRequest request) {
        return departmentService.updateDepartment(id, request.getName());
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
    }

    // DTO 클래스들
    public static class DepartmentCreateRequest {
        private String name;

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }

    public static class DepartmentUpdateRequest {
        private String name;

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }
}
