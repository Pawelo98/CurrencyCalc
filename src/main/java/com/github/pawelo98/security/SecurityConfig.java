package com.github.pawelo98.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/api/**").authenticated()
                .antMatchers("/users").permitAll()
                .antMatchers("/login.html").permitAll()
                .anyRequest().authenticated();

        // http.httpBasic();

        http
                .formLogin()
                .loginPage("/users/login")
                .failureHandler((request, response, exception) -> response.sendError(HttpStatus.BAD_REQUEST.value(),
                        "Username or password invalid"))
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/hello").permitAll();
        http
                .logout()
                .logoutUrl("/users/logout")
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/users/login")
                .permitAll();
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
//        auth.inMemoryAuthentication()
//                .withUser("admin").password("pass").roles("ADMIN")
//                .and()
//                .withUser("user").password("user").roles("USER");
//    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }
}
