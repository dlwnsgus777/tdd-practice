package com.tdd.practice.auth.model.service;


import com.tdd.practice.account.model.service.out.AccountDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TokenProviderTest {
	private TokenProvider tokenProvider;

	@BeforeEach
	void init() {
		this.tokenProvider = new JwtTokenProvider();
	}

	@DisplayName("유저의 정보를 토대로 토큰을 발급한다")
	@Test
	public void createTokenTest() {
		// GIVEN
		AccountDto accountDto = new AccountDto(1L, "test@email.com", "123456");

		// WHEN
		String result = tokenProvider.createToken(accountDto);

		// THEN
		assertThat(result).isNotBlank();

	}

	private class JwtTokenProvider implements TokenProvider {
		private final String secretKey = "test";
		private final long validityInMilliseconds = 3600;


		@Override
		public String createToken(AccountDto accountDto) {
			throw new UnsupportedOperationException("Not implemented yet");
		}
	}
}

