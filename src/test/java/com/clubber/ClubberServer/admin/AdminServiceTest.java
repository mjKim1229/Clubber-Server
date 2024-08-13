package com.clubber.ClubberServer.admin;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.clubber.ClubberServer.domain.admin.domain.Admin;
import com.clubber.ClubberServer.domain.admin.dto.GetAdminsProfileResponse;
import com.clubber.ClubberServer.domain.admin.repository.AdminRepository;
import com.clubber.ClubberServer.domain.admin.service.AdminService;
import com.clubber.ClubberServer.domain.club.domain.Club;
import com.clubber.ClubberServer.global.config.security.AuthDetails;

@ExtendWith(MockitoExtension.class)
public class AdminServiceTest {

	@InjectMocks
	private AdminService adminService;

	@Mock
	private AdminRepository adminRepository;

	@BeforeEach
	void setUp() {
		AuthDetails userDetails = new AuthDetails("1", "admin");
		SecurityContext context = SecurityContextHolder.getContext();
		context.setAuthentication(new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(),
			userDetails.getAuthorities()));
	}

	@Test
	void 동아리계정이_조회될때_알맞은_동아리이름이_조회된다() {
		// Given
		Long currentUserId = 1L;
		String clubName = "club1";
		Admin admin = Admin.builder()
			.id(currentUserId)
			.club(Club.builder().name(clubName).build())
			.build();

		when(adminRepository.findById(currentUserId)).thenReturn(Optional.of(admin));

		// When
		GetAdminsProfileResponse actualResponse = adminService.getAdminsProfile();

		// Then
		assertEquals(actualResponse.getClubName(), admin.getClub().getName());
	}

}
