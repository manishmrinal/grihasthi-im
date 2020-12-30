package com.grihasthi.inventorymanagement.security;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.grihasthi.inventorymanagement.dao.AppUserDetailsServiceDAO;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(AuthenticationManagerBuilder auth)
			throws Exception {

		BCryptPasswordEncoder encoder = passwordEncoder();
		// in-memory authentication
		 auth.inMemoryAuthentication()
		   .withUser("manishmrinal")
		   .password(encoder.encode("manu123"))
		   .roles("Admin");

		// using custom UserDetailsService DAO
		//auth.userDetailsService(new AppUserDetailsServiceDAO());

		// using JDBC
//		Context ctx = new InitialContext();
//		DataSource ds = (DataSource) ctx
//				.lookup("java:/comp/env/jdbc/MyLocalDB");
//
//		final String findUserQuery = "select username,password,enabled "
//				+ "from Employees " + "where username = ?";
//		final String findRoles = "select username,role " + "from Roles "
//				+ "where username = ?";
//		
//		auth.jdbcAuthentication().dataSource(ds)
//				.usersByUsernameQuery(findUserQuery)
//				.authoritiesByUsernameQuery(findRoles);
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		// TODO Auto-generated method stub
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
//      web
//          .ignoring()
//              // Spring Security should completely ignore URLs ending with .html
//              .antMatchers("/*.html");
  
      http
      .csrf().disable()
      .authorizeRequests()
      .antMatchers("/admin/**").hasRole("ADMIN")
      .antMatchers("/anonymous*").anonymous()
      .antMatchers("/login*").permitAll()
      .anyRequest().authenticated()
      .and()
      .formLogin()
      //.loginPage("/login.html")
      //.loginProcessingUrl("/perform_login")
      .defaultSuccessUrl("/", true)
      //.failureUrl("/login.html?error=true")
      //.failureHandler(authenticationFailureHandler())
      .and()
      .logout()
      .logoutUrl("/logout")
      .deleteCookies("JSESSIONID");
      //.logoutSuccessHandler(logoutSuccessHandler());
	
	
	
	
	
//    public void configure(WebSecurity web) throws Exception {
//        web
//            .ignoring()
//                // Spring Security should completely ignore URLs ending with .html
//                .antMatchers("/*.html");
    
        
//        .antMatchers("/admin/**").hasRole("ADMIN")
//        .antMatchers("/anonymous*").anonymous()
//        .antMatchers("/login*").permitAll()
//        .anyRequest().authenticated()
//        .and()
//        .formLogin()
//        .loginPage("/login.html")
//        .loginProcessingUrl("/perform_login")
//        .defaultSuccessUrl("/homepage.html", true)
//        .failureUrl("/login.html?error=true")
//        .failureHandler(authenticationFailureHandler())
//        .and()
//        .logout()
//        .logoutUrl("/perform_logout")
//        .deleteCookies("JSESSIONID")
//        .logoutSuccessHandler(logoutSuccessHandler());
	
	
	
	}

}

