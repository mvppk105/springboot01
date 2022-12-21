package com.globalit.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  /*
   특정 요청들에 대해서는 Security check (권한(authorization) 체크)하지 않기
   "/", "/login", "/sign-up", "/check-email", "/check-email-token",
   "/email-login", "/check-email-login", "/login-link", "/profile/*"
     ㄴ 이 요청들은 모두 권한 확인 없이 접근하도록 함 (GET, POST 요청 모두)
   "/profile/*" 요청은 GET 방식으로 접근할 때만 체크하지 않기
   .anyRequest().authenticated() <-- 나머지 요청은 모두 login 한 상태에서만 접근 허용함
  */
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .mvcMatchers("/", "/login", "/sign-up", "/check-email", "/check-email-token",
                     "/email-login", "/check-email-login", "/login-link")
        .permitAll()
        .mvcMatchers(HttpMethod.GET, "/profile/*")
        .permitAll()
        .anyRequest()
        .authenticated();
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring()
      .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
  }

}
