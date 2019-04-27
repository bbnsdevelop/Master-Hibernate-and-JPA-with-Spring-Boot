package br.com.database.repositories;

import java.sql.Timestamp;
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
	
	public Person findById(int id){
		String query = "select * from person where id=?";
		return jdbcTemplate.queryForObject(query,new Object[] {id} ,new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public int deleteById(int id){
		String query = "delete from person where id=?";
		return jdbcTemplate.update(query,new Object[] {id} );
	}
	
	public int deleteMorePersonByIds(List<Integer> ids){
		String query = "delete from person where id in(?)";
		return jdbcTemplate.update(query,ids.toArray());
	}
	public int insert(Person person){
		String query = "INSERT INTO person (id, name, location, birth_date) VALUES (?, ?, ?, ?)";
		return jdbcTemplate.update(query, new Object[] {person.getId(), person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime())});
	}
	public int update(Person person){
		String query = "update person set name =?, location=?, birth_date=? where id =?";
		return jdbcTemplate.update(query, new Object[] {person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()), person.getId()});
	}

}
