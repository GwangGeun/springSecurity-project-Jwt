package com.example.security.project.securityjwtproject;

import com.example.security.project.securityjwtproject.domain.entity.Account;
import com.example.security.project.securityjwtproject.domain.entity.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.insertAccout();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;

        public void insertAccout() {

            // 계정 추가
            Account account = new Account();
            account.setEmail("hoauys@naver.com");
            account.setGender("M");
            account.setName("정광근");
            em.persist(account);
            Account account2 = new Account();
            account2.setEmail("jgg0328@gmail.com");
            account2.setGender("M");
            account2.setName("룰루랄라");
            em.persist(account2);

            // 게시글 추가
            for (int i = 1; i <= 100; i++) {
                if(i%2==0){
                    Board board = new Board();
                    board.setAccount(account2);
                    board.setTitle("타이틀 "+i);
                    board.setContent("컨텐트 "+i);
                    em.persist(board);
                } else {
                    Board board = new Board();
                    board.setAccount(account);
                    board.setTitle("타이틀 "+i);
                    board.setContent("컨텐트 "+i);
                    em.persist(board);
                }
            }

        }

    }
}
