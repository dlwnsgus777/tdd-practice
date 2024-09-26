package com.tdd.practice.account.model.service.in;

public record SaveAccountInput(
		String email,
		String password
) {
}
