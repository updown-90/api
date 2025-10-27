package com.updown.api.department.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DepartmentEntityTest {

    @Test
    @DisplayName("DepartmentEntity를 생성할 수 있다")
    void createDepartmentEntity() {
        // given
        String name = "개발팀";

        // when
        DepartmentEntity department = DepartmentEntity.create(name);

        // then
        assertThat(department.getName()).isEqualTo(name);
        assertThat(department.getId()).isNull(); // ID는 저장 시점에 생성됨
    }

    @Test
    @DisplayName("null 값으로 DepartmentEntity를 생성할 수 있다")
    void createDepartmentEntityWithNull() {
        // given
        String name = null;

        // when
        DepartmentEntity department = DepartmentEntity.create(name);

        // then
        assertThat(department.getName()).isNull();
    }

    @Test
    @DisplayName("빈 문자열로 DepartmentEntity를 생성할 수 있다")
    void createDepartmentEntityWithEmptyString() {
        // given
        String name = "";

        // when
        DepartmentEntity department = DepartmentEntity.create(name);

        // then
        assertThat(department.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("공백만 있는 문자열로 DepartmentEntity를 생성할 수 있다")
    void createDepartmentEntityWithBlankString() {
        // given
        String name = "   ";

        // when
        DepartmentEntity department = DepartmentEntity.create(name);

        // then
        assertThat(department.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("DepartmentEntity의 이름을 업데이트할 수 있다")
    void updateDepartmentName() {
        // given
        DepartmentEntity department = DepartmentEntity.create("개발팀");
        String newName = "연구개발팀";

        // when
        department.update(newName);

        // then
        assertThat(department.getName()).isEqualTo(newName);
    }

    @Test
    @DisplayName("DepartmentEntity의 이름을 null로 업데이트할 수 있다")
    void updateDepartmentNameWithNull() {
        // given
        DepartmentEntity department = DepartmentEntity.create("개발팀");
        String newName = null;

        // when
        department.update(newName);

        // then
        assertThat(department.getName()).isNull();
    }

    @Test
    @DisplayName("Builder 패턴으로 DepartmentEntity를 생성할 수 있다")
    void createDepartmentEntityWithBuilder() {
        // given
        String name = "마케팅팀";

        // when
        DepartmentEntity department = DepartmentEntity.builder()
                .name(name)
                .build();

        // then
        assertThat(department.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("한글 부서명으로 DepartmentEntity를 생성할 수 있다")
    void createDepartmentEntityWithKoreanName() {
        // given
        String name = "인사관리팀";

        // when
        DepartmentEntity department = DepartmentEntity.create(name);

        // then
        assertThat(department.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("영문 부서명으로 DepartmentEntity를 생성할 수 있다")
    void createDepartmentEntityWithEnglishName() {
        // given
        String name = "Engineering Team";

        // when
        DepartmentEntity department = DepartmentEntity.create(name);

        // then
        assertThat(department.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("특수문자가 포함된 부서명으로 DepartmentEntity를 생성할 수 있다")
    void createDepartmentEntityWithSpecialCharacters() {
        // given
        String name = "R&D Team (연구개발)";

        // when
        DepartmentEntity department = DepartmentEntity.create(name);

        // then
        assertThat(department.getName()).isEqualTo(name);
    }
}
