package com.tdd.practice.account.application;

import java.util.Optional;

import com.tdd.practice.account.api.dto.SignInRequest;
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
		checkExistsAccountByEmail(request.email());
		SaveAccountInput input = new SaveAccountInput(request.email(), encodePassword(request.password()));
		return accountService.save(input);
	}

	private void checkExistsAccountByEmail(String email) {
		Optional<AccountDto> findAccount = accountService.findByEmail(email);
		if (findAccount.isPresent()) {
			throw new IllegalArgumentException("이미 존재하는 회원입니다.");
		}
	}

	private String encodePassword(String password) {
		return passwordEncoder.encode(password);
	}
}
