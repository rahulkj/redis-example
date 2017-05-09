package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	@Autowired
	PersonService personService;

	@RequestMapping(value = "/person", method = RequestMethod.POST, consumes = "application/json")
	public void save(@RequestBody Person person) {
		System.out.println("********* incoming request ********** " + person);

		personService.save(person);
	}

	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET, produces = "application/json")
	public Person get(@PathVariable(name = "id") String id) {
		return personService.get(id);
	}
}
