package com.tdd.practice.account.model.service;

import java.util.Optional;

import com.tdd.practice.account.model.service.in.SaveAccountInput;
import com.tdd.practice.account.model.service.out.AccountDto;

public interface AccountService {

	Optional<AccountDto> findByEmail(String email);

	AccountDto save(SaveAccountInput saveAccountInput);
}
