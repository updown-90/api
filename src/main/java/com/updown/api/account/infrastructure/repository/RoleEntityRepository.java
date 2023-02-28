package com.updown.api.account.infrastructure.repository;

import com.updown.api.account.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleEntityRepository extends JpaRepository<Role, Long> {
    Role findByRoleType(String defaultRoleType);
}
