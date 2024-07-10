package com.clubber.ClubberServer.domain.admin.controller;

import com.clubber.ClubberServer.domain.admin.dto.*;
import com.clubber.ClubberServer.domain.admin.service.AdminService;
import com.clubber.ClubberServer.global.config.swagger.DisableSwaggerSecurity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/admins")
@Tag(name = "[동아리 계정 API]")
public class AdminController {

    private final AdminService adminService;

    @DisableSwaggerSecurity
    @Operation(summary = "동아리 계정 로그인")
    @PostMapping("/login")
    public CreateAdminsLoginResponse createAdminsLogin(@RequestBody @Valid CreateAdminsLoginRequest loginRequest){
        return adminService.createAdminsLogin(loginRequest);
    }

    @Operation(summary = "동아리 계정 비밀번호 수정")
    @PatchMapping("/me")
    public UpdateAdminsPasswordResponse updateAdminsPassword(@RequestBody @Valid
            UpdateAdminsPasswordRequest updateAdminsPasswordRequest){
        return adminService.updateAdminsPassword(updateAdminsPasswordRequest);
    }

    @Operation(summary = "동아리 계정 로그아웃")
    @PostMapping("/logout")
    public void createAdminsLogout(){
        adminService.logout();
    }

    @DisableSwaggerSecurity
    @Operation(summary = "동아리 계정 토큰 재발급")
    @PostMapping("/refresh")
    public CreateAdminsLoginResponse createAdminsTokenRefresh(
            @RequestHeader String refreshToken) {
        return adminService.getAdminsParseToken(refreshToken);
    }


    @Operation(summary = "관리자 개별 동아리 페이지 수정")
    @PatchMapping("/change-page")
    public UpdateClubPageResponse updateAdminsPage(@RequestBody @Valid UpdateClubPageRequest pageRequest){
        System.out.println("관리자 개별 페이지 수정");
        return adminService.updateAdminsPage(pageRequest);
    }
}
