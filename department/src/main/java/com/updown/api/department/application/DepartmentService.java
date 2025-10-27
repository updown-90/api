package com.updown.api.department.application;

import com.updown.api.department.domain.DepartmentEntity;
import com.updown.api.department.infrastructure.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public List<DepartmentEntity> findAll() {
        return departmentRepository.findAll();
    }

    public DepartmentEntity createDepartment(String name) {
        return departmentRepository.save(
                DepartmentEntity.create(name)
        );
    }

    public DepartmentEntity findById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("부서를 찾을 수 없습니다: " + id));
    }

    public DepartmentEntity updateDepartment(Long id, String name) {
        DepartmentEntity department = findById(id);
        department.update(name);
        return departmentRepository.save(department);
    }

    public void deleteDepartment(Long id) {
        DepartmentEntity department = findById(id);
        departmentRepository.delete(department);
    }
}
