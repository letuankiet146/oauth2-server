package hamster.tech.hamsoauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class WebSecurityConfig {
	public static final Integer ROUND_CRYPT = 10;
	
	@Autowired
	private AccountRepo accountRepo;
	
	@Bean
	public SecurityFilterChain defaultSecurityChain(HttpSecurity http) throws Exception {
		return http.authorizeRequests(req->req.anyRequest().authenticated()).formLogin().and().build();
	}
	
	@Bean
	public UserDetailsService userDetailsService () {
		return name-> accountRepo.findByUser(name);
	}
	
	@Bean
	public PasswordEncoder passwordEndcoder() {
		return new BCryptPasswordEncoder(ROUND_CRYPT);
	}
}
