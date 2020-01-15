/**
 * 
 */
package com.mrc.db.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.AllArgsConstructor;

/**
 * @author jsh
 *
 */
@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private MemberService memberService;
	@Autowired AuthProvider authProvider;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception
    {
        // static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 )
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       
       http.csrf().disable();      // 개발 시 에만
       
       http.authorizeRequests()
          .antMatchers("/user/**").access("ROLE_USER")            // 사용자 페이지
          .antMatchers("/admin/**").access("ROLE_ADMIN")            // 관리자 페이지
          .antMatchers("/login","/upload","/download/**").permitAll()
          .antMatchers("/temp/**").permitAll()
          .antMatchers("/member/**").permitAll()
          .antMatchers(HttpMethod.POST,"/temp/**").permitAll()
          .antMatchers(HttpMethod.POST, "/**").permitAll()
          .antMatchers(HttpMethod.POST, "/member/**").permitAll()
          .antMatchers("/**").authenticated();
    
       http.formLogin()
          .loginPage("/member/login")
          .defaultSuccessUrl("/")
          .usernameParameter("member_id")
          .passwordParameter("member_pw");
       
       http.logout()
          .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
          .logoutSuccessUrl("/member/login?rtn=logout")
          .invalidateHttpSession(true);
       
       http.authenticationProvider(authProvider);
    }
    

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
        
    }
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
         return super.authenticationManagerBean();
    }
}
