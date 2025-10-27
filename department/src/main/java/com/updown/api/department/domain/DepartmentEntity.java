package com.updown.api.department.domain;

import com.updown.api.common.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "department")
public class DepartmentEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;


    @Builder
    public DepartmentEntity(String name) {
        this.name = name;
    }

    public static DepartmentEntity create(String name) {
        return DepartmentEntity.builder()
                .name(name)
                .build();
    }

    public void update(String name) {
        this.name = name;
    }
}
