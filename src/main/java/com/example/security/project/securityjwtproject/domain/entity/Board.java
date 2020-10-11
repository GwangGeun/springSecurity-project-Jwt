package com.example.security.project.securityjwtproject.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Board extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idf_board")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idf_account")
    private Account account;

    private String title;
    private String content;

    // 게시글 추가에 사용
    @Builder
    public Board(Account account, String title, String content){
        this.account = account;
        this.title = title;
        this.content = content;
    }

    // 게시글 수정에 사용
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
