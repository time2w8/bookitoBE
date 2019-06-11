package pe.com.fas.bookito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import pe.com.fas.bookito.service.impl.MyUserDetailsService;

@Configuration
@EnableConfigurationProperties
@ComponentScan(basePackages = "pe.com.fas.bookito")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	MyUserDetailsService userDetailsService;

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.cors().and()
	    .csrf().disable()
	    .authorizeRequests()
	    .antMatchers("/","/login","/register","/logout").permitAll()
	    .anyRequest().authenticated()
	    .and().httpBasic()
	    .and().sessionManagement().disable();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(userDetailsService);
	}
}
