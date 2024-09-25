package com.tdd.practice.application;

import com.tdd.practice.account.api.dto.SignInRequest;
import com.tdd.practice.account.application.SignInFacade;
import com.tdd.practice.account.infra.AccountRepository;
import com.tdd.practice.account.infra.DefaultAccountRepository;
import com.tdd.practice.account.model.domain.Account;
import com.tdd.practice.account.model.service.AccountService;
import com.tdd.practice.account.model.service.AccountServiceImpl;
import com.tdd.practice.account.model.service.out.AccountDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SignInFacadeTest {
	private SignInFacade signInFacade;
	private AccountRepository accountRepository = new DefaultAccountRepository();

	@BeforeEach
	void setUp() {
		AccountService accountService = new AccountServiceImpl(accountRepository);
		this.signInFacade = new SignInFacade(accountService);
	}

	@Test
	@DisplayName("회원가입 요청을 바탕으로 유저를 저장한다")
	public void testSignIn() {
		// GIVEN
		String password = "abcd!@#$";
		String email = "test@test.com";
		SignInRequest request = new SignInRequest(email, password);

		// WHEN
		AccountDto result = signInFacade.execute(request);

		// THEN
		assertThat(result.getEmail()).isEqualTo(email);
	}

	@Test
	@DisplayName("이미 존재하는 회원이라면 오류가 발생한다")
	public void testSignI_fail() {
		// GIVEN
		String password = "abcd!@#$";
		String email = "test@test.com";
		SignInRequest request = new SignInRequest(email, password);

		accountRepository.save(Account.builder().email(email).build());

		// WHEN
		Throwable exception = assertThrows(RuntimeException.class, () -> {
			signInFacade.execute(request);
		});

		// THEN
		assertEquals("이미 존재하는 회원입니다.", exception.getMessage());
	}
}