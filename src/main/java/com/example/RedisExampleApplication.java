package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.service.common.RedisServiceInfo;
import org.springframework.cloud.service.keyval.RedisConnectionFactoryCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class RedisExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisExampleApplication.class, args);
	}

	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		Cloud cloud = new CloudFactory().getCloud();
		RedisServiceInfo serviceInfo = (RedisServiceInfo) cloud.getServiceInfo("redis-service");
		RedisConnectionFactory connectionFactory = new RedisConnectionFactoryCreator().create(serviceInfo, null);
		return connectionFactory;
	}
	
	@Bean
	public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		return redisTemplate;
	}
	
}
