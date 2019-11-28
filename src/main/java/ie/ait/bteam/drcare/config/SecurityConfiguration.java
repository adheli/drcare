package ie.ait.bteam.drcare.config;

import ie.ait.bteam.drcare.rest.security.jwt.JwtTokenFilterConfigurer;
import ie.ait.bteam.drcare.rest.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// Disable CSRF (cross site request forgery)
		http.csrf().disable();

		// Apply JWT
		http.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));

		// for now permission to all requests has changed to only login and create services
		http.authorizeRequests()

				.antMatchers("/user/create").permitAll()//
				.antMatchers("/user/login").permitAll()//
				.anyRequest().authenticated();

		// Optional, if you want to test the API from a browser
		http.httpBasic();
	}
}
