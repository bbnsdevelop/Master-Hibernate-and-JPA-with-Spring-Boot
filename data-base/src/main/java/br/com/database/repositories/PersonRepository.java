package br.com.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.database.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{

}
