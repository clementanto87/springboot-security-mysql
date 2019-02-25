package com.infotech.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
    private AccessDeniedHandler accessDeniedHandler;

	/*
	 * @Bean
	 * 
	 * @Override protected UserDetailsService userDetailsService() {
	 * List<UserDetails> userDetails = new ArrayList<>();
	 * userDetails.add((UserDetails)
	 * User.withDefaultPasswordEncoder().username("test").password("test").roles(
	 * "USER").build());
	 * 
	 * return new InMemoryUserDetailsManager(userDetails); }
	 */

	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.userDetailsService(userDetailsService).passwordEncoder(new
	 * BCryptPasswordEncoder()); }
	 */
	
	
	  @Bean public AuthenticationProvider authenticationProvider() {
	  
	  DaoAuthenticationProvider authenticationProvider = new
	  DaoAuthenticationProvider();
	  authenticationProvider.setUserDetailsService(userDetailsService); //
	  //authenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
	  authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
	  return authenticationProvider; }
	 

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests().antMatchers("/login","/register/**","/signup").permitAll()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and()
				.formLogin().loginPage("/login")
				.defaultSuccessUrl("/home")
				.usernameParameter("username")
				.passwordParameter("password")
				.and().logout().invalidateHttpSession(true)
				.clearAuthentication(true).logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/logout-success").permitAll()
				.and()
				.exceptionHandling().accessDeniedHandler(accessDeniedHandler);

	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}
}
