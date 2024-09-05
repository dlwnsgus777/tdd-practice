package com.tdd.practice.account.model.service;

import java.util.Optional;

import com.tdd.practice.account.model.service.out.UserDto;
import org.springframework.stereotype.Component;

@Component
public class AccountServiceImpl implements AccountService {

	@Override
	public Optional<UserDto> findByEmail(String email) {
		throw new UnsupportedOperationException("Not implemented yet");
	}
}
