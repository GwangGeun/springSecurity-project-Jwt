package com.example.security.project.securityjwtproject.domain.repository;

import com.example.security.project.securityjwtproject.domain.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

//    Page<Board> findAll
}
