package com.updown.api.department.infrastructure.repository;

import com.updown.api.department.domain.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
}
