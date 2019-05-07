package br.com.database.service;

import java.util.List;

import br.com.database.entities.Person;

public interface PersonService {
	
	Person findById(int id);
	List<Person> findAll();
	Person create(Person person);
	Person update(Person person);
	void deleteById(int id);
	List<Person> findByIdNativiQuery(int id);
}
