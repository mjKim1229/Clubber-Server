package com.clubber.ClubberServer.domain.user.exception;

import com.clubber.ClubberServer.global.error.BaseErrorCode;
import com.clubber.ClubberServer.global.error.ErrorReason;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;


@AllArgsConstructor
public enum UserErrorCode implements BaseErrorCode {

    USER_ALREADY_DELETED(HttpStatus.BAD_REQUEST.value(), "USER_400_1", "이미 탈퇴한 유저입니다."),
    REFRESH_TOKEN_EXPIRED(HttpStatus.FORBIDDEN.value(), "USER_403_1","리프레시 토큰이 만료되었습니다. 재로그인 해주세요."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "USER_404_1", "존재하지 않는 유저입니다.");


    @Override
    public ErrorReason getErrorReason() {
        return ErrorReason.builder()
                .status(status)
                .code(code)
                .reason(reason).build();
    }

    private final Integer status;
    private final String code;
    private final String reason;

}
