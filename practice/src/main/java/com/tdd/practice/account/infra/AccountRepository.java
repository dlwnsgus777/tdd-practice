package com.tdd.practice.account.infra;

import java.util.Optional;

import com.tdd.practice.account.model.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	Optional<Account> findByEmail(String email);

	Account save(Account account);
}
