package com.tdd.practice.account.model.service;

import java.util.Optional;

import com.tdd.practice.account.infra.AccountRepository;
import com.tdd.practice.account.model.domain.Account;
import com.tdd.practice.account.model.service.in.SaveAccountInput;
import com.tdd.practice.account.model.service.out.AccountDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class AccountServiceTest {
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AccountService accountService;

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


	@Test
	@DisplayName("유저를 저장한다")
	public void saveAccountTest() {
		// GIVEN
		String email = "test@test.com";
		SaveAccountInput saveAccountInput = new SaveAccountInput(
				email,
				"password"
		);

		// WHEN
		AccountDto result = accountService.save(saveAccountInput);

		// THEN
		assertThat(result).isNotNull();
		assertThat(result.getId()).isNotNull();
		assertThat(result.getEmail()).isEqualTo(email);

	}
}