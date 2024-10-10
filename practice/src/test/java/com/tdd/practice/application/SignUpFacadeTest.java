package com.tdd.practice.application;

import com.tdd.practice.account.api.dto.request.SignUpRequest;
import com.tdd.practice.account.application.SignUpFacade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class SignUpFacadeTest {
	@Autowired
	private SignUpFacade signUpFacade;

	@Test
	@DisplayName("로그인 성공 후 토큰을 발급한다")
	public void testSignUp() {
		// GIVEN
		String email = "email@email.com";
		String password = "password";
		SignUpRequest request = new SignUpRequest(email, password);

		// WHEN
		String result = signUpFacade.execute(request);

		// THEN
		assertThat(result).isNotNull();
	}
}