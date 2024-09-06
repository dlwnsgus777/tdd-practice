package com.tdd.practice.account.application;

import com.tdd.practice.account.api.dto.SignInRequest;
import com.tdd.practice.account.model.service.AccountService;
import com.tdd.practice.account.model.service.out.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignInFacade {
	private final AccountService accountService;

	public AccountDto execute(SignInRequest request) {
		throw new UnsupportedOperationException("Not implemented yet");
	}
}
