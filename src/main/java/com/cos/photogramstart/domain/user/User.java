package com.cos.photogramstart.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk 번호 증가 전략이 db를 따라간다.
    private int id;

    private String username;
    private String password;

    private String name;
    private String website; // 웹 사이트
    private String bio; // 자기소개
    private String email;
    private String phone;
    private String gender;

    private String profileImageUrl; // 사진
    private String role;    // 권한

    private LocalDateTime createDate;

    @PrePersist // db에 insert 되기 직전에 실행
    public void createDate() {
        this.createDate = LocalDateTime.now();
    }
}
