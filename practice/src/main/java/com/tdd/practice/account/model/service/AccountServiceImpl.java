package com.tdd.practice.account.model.service;

import java.util.Optional;

import com.tdd.practice.account.infra.AccountRepository;
import com.tdd.practice.account.model.domain.Account;
import com.tdd.practice.account.model.service.in.SaveAccountInput;
import com.tdd.practice.account.model.service.out.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
	private final AccountRepository accountRepository;

	@Override
	public Optional<AccountDto> findByEmail(String email) {
		Optional<Account> result = accountRepository.findByEmail(email);
		return result.map(AccountDto::of);
	}

	@Override
	public AccountDto save(SaveAccountInput saveAccountInput) {
		Account result = accountRepository.save(Account.builder()
														.email(saveAccountInput.email())
														.password(saveAccountInput.password())
														.build());

		return AccountDto.of(result);
	}
}
