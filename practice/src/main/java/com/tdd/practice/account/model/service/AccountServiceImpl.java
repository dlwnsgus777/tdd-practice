package com.tdd.practice.account.model.service;

import java.util.Optional;

import com.tdd.practice.account.infra.AccountRepository;
import com.tdd.practice.account.model.service.out.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
	private final AccountRepository accountRepository;

	@Override
	public Optional<AccountDto> findByEmail(String email) {
		throw new UnsupportedOperationException("Not implemented yet");
	}
}
