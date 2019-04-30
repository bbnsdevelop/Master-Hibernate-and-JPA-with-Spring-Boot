package br.com.database;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.database.service.PersonService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataBaseApplicationTests {

	@Autowired
	PersonService personService;
	
	@Test
	public void contextLoads() {
	
	}
	
	@Test
	public void findAllPerson() {		
		personService.findAll();
	}

}
