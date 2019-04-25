package br.com.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.database.repositories.PersonJdbcDao;

@SpringBootApplication
public class DataBaseApplication implements CommandLineRunner {
	
	private Logger log = LoggerFactory.getLogger(DataBaseApplication.class);
	
	@Autowired
	private PersonJdbcDao personJdbcDao;

	public static void main(String[] args) {
		SpringApplication.run(DataBaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		long start = System.currentTimeMillis();
		log.info("PersonJdbcDao all users -> {} ", personJdbcDao.findAll());
		long stop = System.currentTimeMillis();
		
		log.info("Tempo Total: " + (stop - start) + " ms.");
	}

}
