package com.updown.api.account.domain;

import com.updown.api.common.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "role")
public class Role extends BaseTimeEntity {

    public static final String DEFAULT_ROLE_TYPE = "USER";

    @Builder
    public Role(String roleName, String roleType, String description) {
        this.roleName = roleName;
        this.roleType = roleType;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String roleName;

    private String roleType;

    private String description;

    @OneToMany(fetch = FetchType.LAZY)
    // @JoinColumn: 조인 컬럼은 외래 키를 매핑할 때 사용한다.
    // name 속성에는 매핑할 외래 키 이름을 지정한다.
    // 계정과 권한 테이블은 ROLE_ID 외래 키로 연관관계를 맺으므로 이 값을 지정하면 된다. 이 어노테이션은 생략할 수 있다.
    @JoinColumn(name = "role_id")
    private List<Account> accounts;

    public static Role createDefaultRole() {
        return Role.builder()
                .roleName("일반 사용자")
                .roleType(DEFAULT_ROLE_TYPE)
                .description("기본 권한을 가진 사용자 권한")
                .build();
    }
}
