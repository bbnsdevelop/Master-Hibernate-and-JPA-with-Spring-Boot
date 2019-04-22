package br.com.database.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.database.entities.Person;

@Repository
public class PersonJdbcDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Person> findAll(){
		String query = "select * from person";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<Person>(Person.class));
	}

}
