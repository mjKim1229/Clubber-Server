package com.clubber.ClubberServer.admin;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import com.clubber.ClubberServer.domain.admin.dto.CreateAdminsLoginRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class AdminIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void 유저_로그인() throws Exception {
		String username = "club1";
		String password = "123";
		Long adminId = 2L;

		CreateAdminsLoginRequest createAdminsLoginRequest = new CreateAdminsLoginRequest();
		ReflectionTestUtils.setField(createAdminsLoginRequest, "username", username);
		ReflectionTestUtils.setField(createAdminsLoginRequest, "password", password);

		mockMvc.perform(post("/v1/admins/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(createAdminsLoginRequest)))
			.andExpect(status().isOk())
			.andExpect(cookie().exists("accessToken"))
			.andExpect(cookie().exists("refreshToken"))
			.andExpect(jsonPath("$.data.adminId").value(adminId))
			.andExpect(jsonPath("$.data.username").value(username));
	}
}
