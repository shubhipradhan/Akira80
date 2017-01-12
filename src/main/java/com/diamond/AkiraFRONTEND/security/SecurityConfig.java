package com.diamond.AkiraFRONTEND.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	DataSource dataSource;
	
	@Autowired
    CustomSuccessHandler customSuccessHandler;
	
	
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
	
                      /////////// HARD CODE SECURITY /////////////////
		
		auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN");
		 /*
		auth.inMemoryAuthentication().withUser("shubhi").password("pass").roles("USER");
		
		*/
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username,password,enabled from user where username=?")
		.authoritiesByUsernameQuery("select username,role from user where username=?");
		
		
		/*auth.inMemoryAuthentication().withUser("ravan").password("ravan123").roles("USER");
		  auth.inMemoryAuthentication().withUser("ram").password("ram123").roles("ADMIN");*/
	}
	
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/","/home").permitAll()
		//.antMatchers("/welcomePage/**").access("hasRole('ADMIN')")
		.antMatchers("/welcomePage/**").access("hasAnyRole('ADMIN','USER')")
		.antMatchers("/admin/**").access("hasRole('ADMIN')")
		.antMatchers("/user/**").access("hasRole('USER')")
		.and().formLogin().loginPage("/login").and().csrf().disable();
		
	}*/
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests()
        .antMatchers("/","/homePage").permitAll()
        .antMatchers("/userPage/**").access("hasRole('USER')")
        .antMatchers("/user").access("hasRole('USER')")
        .antMatchers("/adminPage/**").access("hasRole('ADMIN')")
        
        .antMatchers("/adminPage/").access("hasRole('ADMIN')")
        .antMatchers("/admin/").access("hasRole('ADMIN')")
        .antMatchers("/register").access("hasRole('ADMIN')")
        
        .and().formLogin().loginPage("/login").successHandler(customSuccessHandler)
        .usernameParameter("ssoId").passwordParameter("password")
        .and().csrf()
        .and().exceptionHandling().accessDeniedPage("/Access_Denied");
    }
	
	
/*	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/","/home").permitAll()
		.antMatchers("/admin/**").access("hasRole('ADMIN')")
		.and().formLogin()
		.and().exceptionHandling().accessDeniedPage("/Access_Denied");
		
	}*/
	
	
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/","/home").permitAll()
		.antMatchers("/admin/**").access("hasRole('ROLE_USER')")
		.and().formLogin().loginPage("/admin").and().csrf().disable();
		
	}*/
	
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().
		antMatchers("/app/admin/**").access("hasRole('ROLE_ADMIN')").
		antMatchers("/app/user/**").access("hasRole('ROLE_USER')").
		and().formLogin();
	}
	*/
	
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/homePage").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
		.antMatchers("/userPage").access("hasRole('ROLE_USER')")
		.antMatchers("/adminPage").access("hasRole('ROLE_ADMIN')")
		.and()
			.formLogin().loginPage("/login")
			.defaultSuccessUrl("/homePage")
			.failureUrl("/loginPage?error")
			.usernameParameter("username").passwordParameter("password")				
		.and()
			.logout().logoutSuccessUrl("/loginPage?logout"); 
	
		
	}*/
}
