package com.tdd.practice.account.infra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import com.tdd.practice.account.model.domain.Account;
import org.springframework.stereotype.Component;

@Component
public class DefaultAccountRepository implements AccountRepository {
	private final AtomicLong autoGeneratedId = new AtomicLong(0);
	private final List<Account> data = Collections.synchronizedList(new ArrayList<>());

	@Override
	public Optional<Account> findByEmail(String email) {
		return data.stream()
				.filter(item -> item.getEmail()
						.equals(email))
				.findAny();
	}

	@Override
	public Account save(Account account) {
		if (account.getId() == null || account.getId() == 0) {
			Account newAccount = new Account(
					autoGeneratedId.incrementAndGet(),
					account.getEmail(),
					account.getPassword()
			);
			data.add(newAccount);
			return newAccount;
		} else {
			data.removeIf(item -> Objects.equals(item.getId(), account.getId()));
			data.add(account);
			return account;
		}
	}

}
