package com.tdd.practice.account.model.service;

import java.util.Optional;

import com.tdd.practice.account.infra.AccountRepository;
import com.tdd.practice.account.infra.DefaultAccountRepository;
import com.tdd.practice.account.model.domain.Account;
import com.tdd.practice.account.model.service.out.AccountDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AccountServiceTest {
	private AccountRepository accountRepository = new DefaultAccountRepository();
	private AccountService accountService;

	@BeforeEach
	void setUp() {
		accountService = new AccountServiceImpl(accountRepository);
	}

	@Test
	@DisplayName("이메일을 통해 회원을 조회할 수 있다")
	public void findByEmailTest(){
		// GIVEN
		String email = "test@test.com";
		accountRepository.save(Account.builder().email(email).build());

		// WHEN
		Optional<AccountDto> result = accountService.findByEmail(email);

		// THEN
		assertThat(result.isPresent()).isTrue();
	}

}