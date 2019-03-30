package cn.sxt.application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
public class Configs {
	
	//.......  aa
	//获得springboot框架实例化的连接工厂
	@Autowired
	private RedisConnectionFactory connectionFactory;
	/***
	 * @Bean 注解实例化一个类的对象，在spring容器的id是方法名
	 *  <bean id="redisTemplate" class="org.springframework.data.redis.core.RedisTemplate<String, String>">
	 *  </bean>
	 *  
	 *  @Primary, @Bean 可以自己覆盖springboot的提供的对象 
	 * @return
	 */
	@Primary
	@Bean  
	public RedisTemplate<String,String> redisTemplate(){
		System.out.println("========实例化RedisTemplate");
		RedisTemplate<String,String> redisTemplate=new RedisTemplate<>();
		
		//覆盖默认的key序列化方式  GenericToStringSerializer
		redisTemplate.setKeySerializer(
				new GenericToStringSerializer<String>(String.class));
		
		//覆盖默认的value序列化方式  GenericJackson2JsonRedisSerializer
		redisTemplate.setValueSerializer(
				new Jackson2JsonRedisSerializer<String>(String.class));
		/*redisTemplate.setValueSerializer(
				new GenericJackson2JsonRedisSerializer());*/
		
		//注入redis集群连接
		redisTemplate.setConnectionFactory(connectionFactory);
		
		return redisTemplate;
	} 
	
}
