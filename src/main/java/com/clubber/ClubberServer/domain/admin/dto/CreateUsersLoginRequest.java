package com.clubber.ClubberServer.domain.admin.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateUsersLoginRequest {

    @NotBlank
    @Schema(description = "동아리 관리자 ID", example = "club1")
    private String username;

    @NotBlank
    @Schema(description = "동아리 관리자 비밀번호", example = "123")
    private String password;

}
