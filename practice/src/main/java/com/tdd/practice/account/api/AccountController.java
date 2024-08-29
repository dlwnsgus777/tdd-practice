package com.tdd.practice.account.api;

import com.tdd.practice.account.api.dto.SignInRequest;
import com.tdd.practice.account.application.SignInFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {
	private final SignInFacade signInFacade;

	@PostMapping("/sign-in")
	public ResponseEntity<Void> signIn(SignInRequest request) {
		signInFacade.execute(request);
		return ResponseEntity.ok().build();
	}
}
