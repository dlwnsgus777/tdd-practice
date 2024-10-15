package com.tdd.practice.auth.model.service;

import com.tdd.practice.account.model.service.out.AccountDto;

public interface TokenProvider {
	String createToken(AccountDto accountDto);
}
