package one.digitalinnovation.parking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Override
	//configura o login do usuario
	protected void configure(AuthenticationManagerBuilder auth) throws Excepction{
		auth.inMemoryAuthentication()
			.withUser("user");
			.password("Dio@123")
			.roles("USER")
			.and()
			.passwordEncoder(passwordEncoder());
			
	}
	
	@Override
	//Configura a autorização
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests()
			.antMatchers("/swagger-vi.html").permitAll()
			.antMatchers("/swagger-resourcer/**").permitAll()
			.antMatchers("/webjars/**").permitAll()
			.antMatchers("/v2/api-docs/**").permitAll()
			.antMatchers("/").permitAll()
			.antMatchers("/crsf").permitAll()
			.antMatchers("/*.js").permitAll()
			.antMatchers("/*.css").permitAll()
			.antMatchers("/*.ico").permitAll()
			.antMatchers("/*.png").permitAll()
			.anyRequest().authenticated();
			
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
