/**
 * 
 */
package example.spring.session.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Neev
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"example.spring.session.controller","example.spring.session.service","example.spring.session.dao"})
@Import({SecurityConfig.class,HttpSessionConfig.class,HibernateConfig.class})
public class AppConfig {

	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder;
	}
}
