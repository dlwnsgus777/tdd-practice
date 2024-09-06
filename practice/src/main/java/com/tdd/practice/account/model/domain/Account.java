package com.tdd.practice.account.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Account {
	private Long id;
	private String email;
	private String password;
}
