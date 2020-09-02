package com.rab3tech;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.rab3tech.security.service.UserSpringSecuirtyAuthProvider;

@Configuration 
@EnableWebSecurity 
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter { 
	
	
   @Autowired	
   private UserSpringSecuirtyAuthProvider userSpringSecurityAuthProvider;
	
/*	@Autowired
	@Qualifier("SpringSecurityServiceImpl")
	private SpringSecurityService springSecurityService;*/
   
   @Autowired
   private BCryptPasswordEncoder bCryptPasswordEncoder;
   
   @PostConstruct
   public void  init() {
	   System.out.println("SecurityConfigurationSecurityConfigurationSecurityConfigurationSecurityConfigurationSecurityConfigurationSecurityConfigurationSecurityConfigurationSecurityConfiguration");
   }
   
   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userSpringSecurityAuthProvider).passwordEncoder(bCryptPasswordEncoder);
   }
	// <bean id="bcryptEncoder" class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder" />
   
 
  @Override 
  protected void configure(HttpSecurity http) throws Exception {   
    http.authorizeRequests() 
        .antMatchers("/**").permitAll().antMatchers("/admin/**").hasAuthority("ADMIN"); 
   http.csrf().disable();
    //for login
    /*http.formLogin().failureHandler(customAuthenticationFailureHandler())*/
    http.formLogin().failureUrl("/customer/login?error=true")
    .loginPage("/customer/login")
    .defaultSuccessUrl("/customer/dashboard")
    /*.failureUrl("/corp/auth?error=true")*/
    .and().exceptionHandling()
    .accessDeniedPage("/access/denied")
    .and()
    .logout().logoutUrl("/customer/logout")
    .logoutSuccessUrl("/logout/success")
    .invalidateHttpSession(true) 
    .permitAll()
    .deleteCookies("JSESSIONID");
    /* http.authorizeRequests()*/
    
 /*   .antMatchers("/", "/*.html").permitAll()
    .antMatchers("/user/**").hasRole("USER")
   
    .antMatchers("/admin/login").permitAll()
    .antMatchers("/user/login").permitAll()
    .anyRequest().authenticated()
    .and()
    .csrf().disable();*/
  } 
  
 
  /*@Bean
  public AuthenticationFailureHandler customAuthenticationFailureHandler() {
      return new LoginFailureUserAuthHandler(springSecurityService);
  }*/
  
}