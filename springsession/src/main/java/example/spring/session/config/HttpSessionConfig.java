/**
 * 
 */
package example.spring.session.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.redis.embedded.EnableEmbeddedRedis;
import org.springframework.session.redis.embedded.RedisServerPort;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

/**
 * @author Neev
 *
 */
@Configuration
@EnableEmbeddedRedis
@EnableRedisHttpSession
public class HttpSessionConfig {

	@Bean
	public JedisConnectionFactory getJedisConnectionFactory(@RedisServerPort int port){
		JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
		connectionFactory.setPort(port);
		return connectionFactory;
	}
	
	@Bean
	public HttpSessionStrategy httpSessionStrategy(){
		return new HeaderHttpSessionStrategy();
	}
}
