package com.codesoom.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * JwtUtil에 대한 테스트 클래스
 */
class JwtUtilTest {
    private static final String SECRET = "12345678901234567890123456789012";
    private static final String VALID_TOKEN = "eyJhbGciOiJIUzI1NiJ9." +
            "eyJ1c2VySWQiOjF9.ZZ3CUl0jxeLGvQ1Js5nG2Ty5qGTlqai5ubDMXZOdaDk";

    private static final Long ID = 1L;

    private JwtUtil jwtUtil;

    @BeforeEach
    void setUp() {
        jwtUtil = new JwtUtil(SECRET);
    }

    // TODO: 인코딩 테스트
    //  - 호출 시 유효한 토큰을 반환해야 한다.
    @Nested
    @DisplayName("encodeUserId 메서드는")
    class Describe_encodeUserId_method {
        @Nested
        @DisplayName("id가 주어지면")
        class Context_if_id_given {
            String subject() {
                return jwtUtil.encodeUserId(ID);
            }

            @Test
            @DisplayName("유효한 토큰을 반환한다")
            void It_returns_valid_token() {
                String token = subject();

                assertThat(token).isEqualTo(VALID_TOKEN);
            }
        }
    }

    // TODO: 디코딩 테스트
    //  - 유효한 토큰으로 호출 시 반환된 Claim에 유효한 id가 들어있어야 한다.
    //  - 유효하지 않은 토큰으로 호출 시 InvalidTokenException 예외를 던져야 한다.
}
