package com.tdd.practice.account.application;

import java.util.Optional;

import com.tdd.practice.account.api.dto.SignInRequest;
import com.tdd.practice.account.model.domain.Account;
import com.tdd.practice.account.model.service.AccountService;
import com.tdd.practice.account.model.service.in.SaveAccountInput;
import com.tdd.practice.account.model.service.out.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignInFacade {
	private final AccountService accountService;
	private final PasswordEncoder passwordEncoder;

	public AccountDto execute(SignInRequest request) {
		Optional<AccountDto> findAccount = accountService.findByEmail(request.email());
		if (findAccount.isPresent()) {
			throw new IllegalArgumentException("이미 존재하는 회원입니다.");
		}

		SaveAccountInput input = new SaveAccountInput(request.email(), encodePassword(request));

		return accountService.save(input);
	}

	private String encodePassword(SignInRequest request) {
		return passwordEncoder.encode(request.password());
	}
}
