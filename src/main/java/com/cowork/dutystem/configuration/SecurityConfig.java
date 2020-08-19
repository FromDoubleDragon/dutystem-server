package com.cowork.dutystem.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and() //cors Filter 사용
                .csrf().disable()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 세션의 상태를 가지지 않겠다.
                    .and()
                .authorizeRequests()    // 이제부터 request의 인증을 확인하겠다.
                    .antMatchers(HttpMethod.OPTIONS, "/**").permitAll() //브라우저의 preflight 요청은 무조건 허용 -> cors 이슈와 관련이 있다.
                // 허용할 uri를 하나씩 추가하면 된다.
/* ==================================================== 허용할 URL ============================================================================ */
                .antMatchers("/api/v1/test/permit-all").permitAll()     // /test/permit-all 이라는 uri는 무조건 인증허용이다.

/* ========================================================================================================================================== */

/* ==================================================== 인증할 URL ============================================================================ */
                .antMatchers("/api/v1/test/auth").authenticated()   // /test/auth 라는 uri는 무조건 인증을 받아야한다.

/* ========================================================================================================================================== */
                .antMatchers("/**").authenticated()          // 위를 포함하지 않는 나머지는 모두 인증을 받아야 한다.
                .anyRequest().permitAll().and()

                .formLogin().disable()
        ;
    }
}
