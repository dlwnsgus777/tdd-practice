package com.tdd.practice.application;

import com.tdd.practice.account.api.dto.SignInRequest;
import com.tdd.practice.account.application.SignInFacade;
import com.tdd.practice.account.model.service.out.UserDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SignInFacadeTest {
	@Autowired
	private SignInFacade signInFacade;

	@Test
	@DisplayName("회원가입 요청을 바탕으로 유저를 저장한다")
	public void testSignIn() {
		// GIVEN
		String password = "abcd!@#$";
		String email = "test@test.com";
		SignInRequest request = new SignInRequest(email, password);

		// WHEN
		UserDto result = signInFacade.execute(request);

		// THEN
		assertThat(result.getEmail()).isEqualTo(email);
	}

}