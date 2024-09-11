package com.tdd.practice.account.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Account {
	private Long id;
	private String email;
	private String password;

	@Builder
	public Account(Long id, String email, String password) {
		this.id = id;
		this.email = email;
		this.password = password;
	}
}
