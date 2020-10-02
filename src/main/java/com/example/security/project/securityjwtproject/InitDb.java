package com.example.security.project.securityjwtproject;

import com.example.security.project.securityjwtproject.domain.entity.Account;
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
    public void init(){
        initService.insertAccout();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService{

        private final EntityManager em;

        public void insertAccout(){
            Account account = new Account();
            account.setEmail("hoauys@naver.com");
            account.setGender("M");
            account.setName("정광근");
            em.persist(account);
        }
    }
}
