package com.tdd.practice.account.model.service.out;

import com.tdd.practice.account.model.domain.Account;
import lombok.Builder;
import lombok.Getter;

@Getter
public class AccountDto {
	private Long id;
	private String email;
	private String password;

	@Builder
	public AccountDto(Long id, String email, String password) {
		this.id = id;
		this.email = email;
		this.password = password;
	}

	public static AccountDto of(Account account) {
		return AccountDto.builder()
				.id(account.getId())
				.email(account.getEmail())
				.password(account.getPassword())
				.build();
	}
}
