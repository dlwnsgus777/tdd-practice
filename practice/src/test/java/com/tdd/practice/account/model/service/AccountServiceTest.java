package com.tdd.practice.account.model.service;

import java.util.Optional;

import com.tdd.practice.account.model.service.out.UserDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {
	private AccountService accountService = new AccountServiceImpl();

	@Test
	@DisplayName("이메일을 통해 회원을 조회할 수 있다")
	public void findByEmailTest(){
		// GIVEN
		String email = "test@test.com";

		// WHEN
		Optional<UserDto> result = accountService.findByEmail(email);

		// THEN
		assertThat(result.isPresent()).isTrue();

	}


	private static class AccountServiceImpl implements AccountService {
	}
}