package br.com.silvanopessoa.repository;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import br.com.silvanopessoa.jedis.model.Person;

public class PersonRepositoryTest {
	private PersonRepository repository;
	
	@Before
	public void init(){
		repository = new PersonRepository();
	}
			
	@Test
	public void deveSalvarPersoneObter() throws ParseException {
		Person generatePerson = this.generatePerson();
		repository.save(generatePerson);
		Person person = repository.get("person:Silvano Pessoa");
		assertNotNull(person);
		assertEquals(generatePerson.getName(), person.getName());
		assertNotNull(person.getModifyDate());
	}
	
	private Person generatePerson(){
		Person person = new Person();
		person.setName("Silvano Pessoa");
		person.setModifyDate(new Date());
		return person;
	}

}
