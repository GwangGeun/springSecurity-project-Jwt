package com.example.security.project.securityjwtproject.domain.repository;

import com.example.security.project.securityjwtproject.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
