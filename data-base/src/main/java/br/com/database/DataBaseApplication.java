package br.com.database;

import java.sql.Date;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.database.entities.Person;
import br.com.database.repositories.PersonJdbcDao;
import br.com.database.repositories.namedQuery.PersonJpaRepository;
import br.com.database.service.PersonService;

@SpringBootApplication
public class DataBaseApplication implements CommandLineRunner {
	
	private Logger log = LoggerFactory.getLogger(DataBaseApplication.class);
	
	
	@Autowired
	private PersonJdbcDao personJdbcDao;

	@Autowired
	private PersonService personService;
	
	@Autowired
	private PersonJpaRepository PersonJpaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DataBaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		long start = System.currentTimeMillis();
		log.info("PersonJdbcDao all users -> {} ", personJdbcDao.findAll());
		log.info("PersonJdbcDao all users with rowMapper -> {} ", personJdbcDao.findAllRowMapper());
		
				
		log.info("find person by id -> {}", this.personJdbcDao.findById(1003));
		log.info("find person by id with rowMapper -> {}", this.personJdbcDao.findByIdRowMapper(1003));
		
		
		log.info("delete person by number -> {}", this.personJdbcDao.deleteById(1003));
		log.info("delete person by number -> {}", this.personJdbcDao.deleteById(1003));
		//log.info("delete sum person by id's -> {}", this.personJdbcDao.deleteMorePersonByIds(Arrays.asList(1002, 1004)));
		log.info("insert person -> {}", this.personJdbcDao.insert(new Person(1005, "Maria", "Rio de Janeiro", new Date(Calendar.getInstance().getTime().getTime()))));
		log.info("update person -> {}", this.personJdbcDao.update(new Person(1005, "Maria das flores", "Rio de Janeiro", new Date(Calendar.getInstance().getTime().getTime()))));
		
		log.info("find by id jpa -> {} -> {}", 1001, personService.findById(1001));
		log.info("create person  jpa-> {}", this.personService.create(new Person("Maria", "Rio de Janeiro", new Date(Calendar.getInstance().getTime().getTime()))));
		log.info("find all person jpa -> {} ", personService.findAll());
		
		log.info("find all person namedQuery -> {}", PersonJpaRepository.findAllPerson());
		// time
		long stop = System.currentTimeMillis();
		log.info("Tempo Total: " + (stop - start) + " ms.");
	}

}
