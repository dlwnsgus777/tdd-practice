package com.tdd.practice.account.api;

import com.tdd.practice.account.api.dto.request.SignInRequest;
import com.tdd.practice.account.api.dto.request.SignUpRequest;
import com.tdd.practice.account.api.dto.response.SignUpResponse;
import com.tdd.practice.account.application.SignInFacade;
import com.tdd.practice.account.application.SignUpFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {
	private final SignInFacade signInFacade;
	private final SignUpFacade signUpFacade;

	@PostMapping("/sign-in")
	public ResponseEntity<Void> signIn(@RequestBody SignInRequest request) {
		signInFacade.execute(request);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/sign-up")
	public ResponseEntity<SignUpResponse> signIn(@RequestBody SignUpRequest request) {
		return ResponseEntity.ok().build();
	}
}
