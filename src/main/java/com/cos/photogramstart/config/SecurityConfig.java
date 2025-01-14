package com.cos.photogramstart.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity // 해당 파일로 시큐리티를 활성화
@Configuration // IOC
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // super 삭제 - 기존 시큐리티가 가지고 있는 기능 다 삭제
        //         super.configure(http);

        //csrf 비활성화
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/", "/users/**", "/image/**", "/subscribe/**", "/comment/**")
                .authenticated()// 위 url 요청은 인증 필요
                .anyRequest()
                .permitAll() // 그 외 요청은 허용
                .and()
                .formLogin() // 인증 필요한 요청이 들어오면
                .loginPage("/auth/signin") // 이 url로 보내겠다
                .defaultSuccessUrl("/");
    }
}
