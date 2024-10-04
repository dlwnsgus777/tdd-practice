package com.tdd.practice.account.infra;

import java.util.Optional;

import com.tdd.practice.account.model.domain.Account;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class AccountRepositoryTest {
	@Autowired
	private AccountRepository accountRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Test
	@DisplayName("회원을 저장한다")
	public void test_accountSave() {
		// GIVEN
		String email = "test@test.com";
		String password = "password";

		// WHEN
		accountRepository.save(Account.builder()
									   .email(email)
									   .password(password)
									   .build());

		// THEN
		entityManager.flush();
		Optional<Account> result = accountRepository.findByEmail(email);
		assertThat(result).isNotNull();
		assertThat(result.isPresent()).isTrue();
	}

}