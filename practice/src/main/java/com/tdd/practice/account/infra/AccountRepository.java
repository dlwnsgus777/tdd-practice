package com.tdd.practice.account.infra;

import java.util.Optional;

import com.tdd.practice.account.model.domain.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository {
	Optional<Account> findByEmail(String email);

	Account save(Account account);
}
