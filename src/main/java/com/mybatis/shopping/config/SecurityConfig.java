package com.mybatis.shopping.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //빈 등록(Ioc관리)빈등록 :  스프링 컨테이너에서 객체를 관리할 수 있게 하는 것
@EnableWebSecurity //시큐리티에 필터가 등록이 된다. 설정은 아래에서 하면된다.
public class SecurityConfig {


}
