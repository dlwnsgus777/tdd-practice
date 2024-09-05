package com.tdd.practice.account.model.service;

import java.util.Optional;

import com.tdd.practice.account.model.service.out.UserDto;

public interface AccountService {

	Optional<UserDto> findByEmail(String email);
}
