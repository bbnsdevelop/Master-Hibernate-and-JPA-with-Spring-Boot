package br.com.database.repositories.namedQuery;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.database.entities.Person;

@Repository
@Transactional
public class PersonJpaRepository {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Person> findAllPerson(){
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_person", Person.class);
		return namedQuery.getResultList();
	}
}
