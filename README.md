# 멀티모듈 API

Spring Boot 기반의 멀티모듈 마이크로서비스 API 프로젝트입니다.

## 📋 프로젝트 개요

이 프로젝트는 Spring Boot 3.2.1과 Java 17을 기반으로 한 멀티모듈 아키텍처를 채택한 REST API 서비스입니다. 각 도메인별로 독립적인 모듈로 구성되어 있어 확장성과 유지보수성을 높였습니다.

## 🏗️ 아키텍처

### 모듈 구조
```
api/
├── common/                    # 공통 모듈
│   ├── src/main/java/com/updown/api/common/
│   │   ├── aop/              # AOP 관련
│   │   ├── config/           # 설정
│   │   ├── domain/           # 공통 도메인
│   │   ├── exception/        # 예외 처리
│   │   ├── jwt/              # JWT 관련
│   │   └── security/         # 보안 관련
├── account/                  # 계정 관리 모듈
│   ├── src/main/java/com/updown/api/account/
│   │   ├── application/      # 애플리케이션 계층
│   │   ├── domain/           # 도메인 계층
│   │   ├── infrastructure/   # 인프라 계층
│   │   ├── presentation/     # 프레젠테이션 계층
│   │   └── security/         # 보안 관련
├── department/               # 부서 관리 모듈
│   ├── src/main/java/com/updown/api/department/
│   │   ├── application/      # 애플리케이션 계층
│   │   ├── domain/           # 도메인 계층
│   │   ├── infrastructure/   # 인프라 계층
│   │   └── presentation/     # 프레젠테이션 계층
├── login/                    # 로그인 모듈
│   └── src/main/java/com/updown/api/login/
│       └── presentation/     # 프레젠테이션 계층
└── src/main/java/            # 메인 애플리케이션
    └── com/updown/api/
        └── ApiApplication.java
```

### 기술 스택

#### 🏗️ 핵심 프레임워크
- **Java**: 17 (LTS)
- **Spring Boot**: 3.2.1
- **Spring Security**: 6.x (JWT 기반 인증)
- **Spring Data JPA**: 3.x (데이터 접근 계층)
- **Spring Cloud**: 2023.0.0 (Circuit Breaker)

#### 🗄️ 데이터베이스 & ORM
- **H2 Database**: 인메모리 데이터베이스 (개발용)
- **JPA/Hibernate**: ORM 프레임워크
- **QueryDSL**: 5.0.0 (타입 안전한 쿼리 작성)

#### 🔧 개발 도구
- **Lombok**: 1.18.x (보일러플레이트 코드 제거)
- **MapStruct**: 1.5.3 (객체 매핑)
- **Gradle**: 빌드 도구
- **Spring Boot DevTools**: 개발 편의성

#### 🔐 보안 & 인증
- **JWT (JSON Web Token)**: 0.11.5
- **BCrypt**: 비밀번호 암호화
- **Spring Security**: 인증/인가

#### 🧪 테스트
- **JUnit 5**: 단위 테스트
- **Spring Boot Test**: 통합 테스트
- **Spring Security Test**: 보안 테스트

#### 📊 모니터링 & 관찰성
- **Spring Boot Actuator**: 헬스 체크
- **Resilience4j**: 서킷 브레이커 패턴
- **AOP (Aspect-Oriented Programming)**: 로깅 및 모니터링

**📚 추가 자료**
- [Spring Boot 공식 문서](https://spring.io/projects/spring-boot)
- [Spring Security 가이드](https://spring.io/guides/topicals/spring-security-architecture/)
- [JPA Best Practices](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
- [QueryDSL 가이드](http://querydsl.com/static/querydsl/4.4.0/reference/html_single/)
