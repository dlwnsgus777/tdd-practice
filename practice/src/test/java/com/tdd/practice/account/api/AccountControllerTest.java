package com.tdd.practice.account.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tdd.practice.account.api.dto.SignInRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	@DisplayName("회원가입 요청에 성공한다")
	public void testSignIn() throws Exception {
		// GIVEN
		String password = "abcd!@#$";
		String email = "test@test.com";
		SignInRequest request = new SignInRequest(email, password);

		// WHEN
		MockHttpServletResponse response = mockMvc.perform
						(post("/api/v1/accounts/sign-in")
								 .contentType(MediaType.APPLICATION_JSON)
								 .content(objectMapper.writeValueAsBytes(request)))
				.andReturn()
				.getResponse();

		// THEN
		assertThat(response.getStatus()).isEqualTo(200);
	}

}