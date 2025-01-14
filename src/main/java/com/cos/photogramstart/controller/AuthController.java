package com.cos.photogramstart.controller;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.dto.auth.SignupDto;
import com.cos.photogramstart.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RequiredArgsConstructor    // final 필드 DI할 때 사용
@Controller // 1.IOC등록 2.File 리턴하는 컨트롤러
public class AuthController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final AuthService authService;

//    public AuthController(AuthService authService) {
//        this.authService = authService;
//    }

    @GetMapping("/auth/signin")
    public String signinForm() {
        return "auth/signin";
    }

    @GetMapping("/auth/signup")
    public String signupForm() {
        return "auth/signup";
    }

    @PostMapping("/auth/signup")
    public String signup(SignupDto signupDto) { // key=value (x-www-form-urlencoded) 기본적으로 Spring Controller가 받는 형식
        User user = signupDto.toEntity();
        User userEntity = authService.회원가입(user);
        System.out.println("userEntity = " + userEntity);
        return "auth/signin";
    }
}
