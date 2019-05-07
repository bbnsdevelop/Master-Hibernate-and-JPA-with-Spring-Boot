package br.com.database.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.database.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{
	
	@Query(value="select * from person where id in (?1)", nativeQuery = true )
	List<Person> findByIdNativiQuery(List<Integer> id);

}
