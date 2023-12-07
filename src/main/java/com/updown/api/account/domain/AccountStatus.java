package com.updown.api.account.domain;

/**
 * enum 사용시 비교는 등호연산자( == ) 를 활용하시는 것을 추천합니다.
 * equals 의 경우 NullPointException이 발생할 수 있습니다.
 * 이를 피하기 위해 CODE.equals(code) 처럼 상수나 enum 을 앞에 두는 방식으로 코딩하기도 합니다.
 * == record 경우 NullSafe 합니다. 컴파일 단계에서 Error 가 발생할 수 있어 IDE에서 발견하기 용이합니다.
 */
public enum AccountStatus {
    NORMAL, STOP
}
