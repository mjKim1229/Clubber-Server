package com.clubber.ClubberServer.domain.auth.controller;


import static com.clubber.ClubberServer.global.jwt.JwtStatic.*;

import com.clubber.ClubberServer.domain.auth.dto.KakaoOauthResponse;
import com.clubber.ClubberServer.domain.auth.service.helper.CookieHelper;
import com.clubber.ClubberServer.domain.user.domain.User;
import com.clubber.ClubberServer.domain.auth.service.AuthService;
import com.clubber.ClubberServer.global.config.swagger.DisableSwaggerSecurity;
import com.clubber.ClubberServer.global.infrastructure.outer.api.oauth.dto.KakaoTokenResponse;
import com.clubber.ClubberServer.global.infrastructure.outer.api.oauth.dto.KakaoUserInfoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/auths")
@RequiredArgsConstructor
@Tag(name = "[인증]")
public class AuthController {

    private final AuthService authService;

    private final CookieHelper cookieHelper;

    @Operation(summary = "카카오 로그인 code 전송 후 로그인 처리", description = "code만 보내면 됩니다. (Host, Origin)은 안 보내도 됨")
    @GetMapping("/oauth/kakao")
    @DisableSwaggerSecurity
    public ResponseEntity<KakaoOauthResponse> getCredentialFromKakao(@RequestParam String code,
            @RequestHeader(required = false) String Host,
            @RequestHeader(required = false) String Referer){
        log.info("Host"+ Host);
        log.info("Referer"+ Referer);

        KakaoTokenResponse kakaoToken = null;
        if(Referer.contains(Host)){
            if(Referer.contains("dev")){
                //스테이징 서버
                kakaoToken =  authService.getToken(code, DEV_CLIENT);
            }else {
                //개발 서버
                kakaoToken = authService.getToken(code, PROD_CLIENT);
            }
        }else{
            kakaoToken = authService.getToken(code, LOCAL_CLIENT);
        }
        KakaoUserInfoResponse userKakaoInfo = authService.getUserKakaoInfo(
                kakaoToken.getAccessToken());
        User user = authService.loginOrSignUp(userKakaoInfo);
        KakaoOauthResponse kakaoOauthResponse = authService.generateUserToken(user);
        return ResponseEntity.ok()
                .headers(cookieHelper.getCookies(kakaoOauthResponse.getAccessToken(), kakaoOauthResponse.getRefreshToken()))
                .body(kakaoOauthResponse);
    }

    @Operation(summary = "토큰 재발급", description = "토큰 만료시 호출 API",
    parameters = {
            @Parameter(name = "refreshToken", description = "헤더에 리프레시 토큰 전달", in = ParameterIn.HEADER),
            @Parameter(name = "refreshToken", description = "쿠키에 리프레시 토큰 전달 (추후에 적용)", in = ParameterIn.COOKIE)
    })
    @PostMapping("/refresh")
    @DisableSwaggerSecurity
    public ResponseEntity<KakaoOauthResponse> tokenRefresh(
            @CookieValue(value = "refreshToken", required = false) String refreshTokenCookie,
            @RequestHeader(value = "refreshToken", required = false, defaultValue = "") String refreshToken){

        KakaoOauthResponse kakaoOauthResponse = authService.tokenRefresh(
                refreshTokenCookie != null ? refreshTokenCookie : refreshToken);
        return ResponseEntity.ok()
                .headers(cookieHelper.getCookies(kakaoOauthResponse.getAccessToken(),
                    kakaoOauthResponse.getRefreshToken()))
                .body(kakaoOauthResponse);
    }

    @Operation(summary = "카카오 로그아웃")
    @PostMapping("/logout")
    public ResponseEntity logOutKakaoUser(){

        authService.logoutKakaoUser();
        return ResponseEntity.ok()
                .headers(cookieHelper.deleteCookies())
                .body(null);
    }


    @Operation(summary = "카카오 회원탈퇴")
    @DeleteMapping("/withdraw")
    public ResponseEntity withDrawKakaoUser(){

        authService.withDrawKakaoUser();
        return ResponseEntity.ok()
                .headers(cookieHelper.deleteCookies())
                .body(null);
    }
}
