/*package com.tweetapp.security;

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
	DataSource dataSource ;
	
	@Autowired
	public void configureAMBuilder(AuthenticationManagerBuilder auth) throws Exception {
		//auth.jdbcAuthentication().dataSource(dataSource)
				// to provide role of user
				//.authoritiesByUsernameQuery("select email, role FROM USERS where email=?")
				// to provide credentials of user
				//.usersByUsernameQuery("select LOGINID,PASSWORD FROM USERS where LOGINID=?");
		
		auth.inMemoryAuthentication()
		.passwordEncoder(org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance())
		.withUser("user").password("pass").roles("USER")
		.and().withUser("admin").password("pass").roles("USER", "ADMIN")
		.and().withUser("slr").password("pass").roles("SELR");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 //http.httpBasic().and().authorizeRequests().anyRequest().authenticated().and().cors().disable();
		 //http.csrf().disable();
		 http
	        .csrf().disable()   
	        .authorizeRequests()
	        .antMatchers("/**").permitAll()
	                .anyRequest().authenticated()
	                .and()
	            //.formLogin().and()
	            .httpBasic();
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
	    CorsConfiguration configuration = new CorsConfiguration();
	    configuration.setAllowedOrigins(Arrays.asList("*"));
	    configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", 
	    "DELETE", "OPTIONS"));
	    configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", 
	    "x-auth-token"));
	    configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
	    UrlBasedCorsConfigurationSource source = new 
	    UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", configuration);

	    return source;
	}
	
}*/


