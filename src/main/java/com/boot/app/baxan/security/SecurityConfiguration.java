package com.boot.app.baxan.security;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	//change username and password
//	@Autowired
//	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception
//	{
//		auth.inMemoryAuthentication().withUser("baxan").password("9845895132").roles("USER","ADMIN");
//	}
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.authorizeRequests()
//				//.antMatchers( "/").permitAll()		
//				.antMatchers("/" ,"/user", "userLogin").hasRole("USER")			
//				.and()
//			.formLogin()
//				.loginPage("/login").failureUrl("/login-error");	
//	}
}


