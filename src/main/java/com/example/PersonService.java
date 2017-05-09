package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	@Autowired
	RedisTemplate<String, Person> redisTemplate;

	public void save(Person person) {
		System.out.println("***********" + person);
		redisTemplate.opsForValue().set(person.id, person);
	}

	public Person get(String id) {
		return redisTemplate.opsForValue().get(id);
	}
}
