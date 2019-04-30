package br.com.database.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.database.entities.Person;
import br.com.database.repositories.PersonRepository;
import br.com.database.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public Person findById(int id) {
		logger.info("find person jpa by id -> {}", id);
		return personRepository.findById(id).get();
	}

	@Override
	public List<Person> findAll() {
		logger.info("find all person jpa");
		return personRepository.findAll();
	}

	@Override
	public Person create(Person person) {
		logger.info("create person jpa -> {}", person);
		return personRepository.save(person);
	}

	@Override
	public Person update(Person person) {
		logger.info("update person jpa -> {}", person);
		return personRepository.save(person);
	}

	@Override
	public void deleteById(int id) {
		logger.info("delete person jpa by id -> {}", id);
		personRepository.deleteById(id);		
	}
	
	
}
