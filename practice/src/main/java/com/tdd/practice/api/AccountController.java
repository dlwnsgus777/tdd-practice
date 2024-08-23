package com.tdd.practice.api;

import com.tdd.practice.api.dto.SignInRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

	@PostMapping("/sign-in")
	public ResponseEntity<Void> signIn(SignInRequest request) {
		return ResponseEntity.ok().build();
	}
}
