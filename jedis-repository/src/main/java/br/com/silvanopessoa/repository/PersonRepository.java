package br.com.silvanopessoa.repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import redis.clients.jedis.Jedis;
import br.com.silvanopessoa.jedis.model.Person;
import br.com.silvanopessoa.repository.conf.ConnectionDB;

/**
 * The Class PersonRepository.
 */
public class PersonRepository {

	/** The conn. */
	private Jedis conn;
	
	/**
	 * Instantiates a new person repository.
	 */
	public PersonRepository() {
		this.conn = new ConnectionDB().getConnection();
	}
	
	/**
	 * Save.
	 *
	 * @param person the person
	 */
	public void save(Person person){
		String key = "person:"+person.getName();
		conn.hset(key, "name",person.getName());
		DateFormat formatter = new SimpleDateFormat("MMM/d/yyyy HH:mm:ss");
		conn.hset(key, "modifyDate",formatter.format(person.getModifyDate()));
	}
	
	/**
	 * Gets the.
	 *
	 * @param key the key
	 * @return the person
	 * @throws ParseException the parse exception
	 */
	public Person get(String key) throws ParseException{
		if(conn.exists(key)){
			Person person = new Person();
			person.setName(conn.hget(key, "name"));
			DateFormat formatter = new SimpleDateFormat("MMM/d/yyyy HH:mm:ss");  
			person.setModifyDate(formatter.parse(conn.hget(key, "modifyDate")));
			return person;
		}
		return null;
	}
	
	/**
	 * Gets the performace.
	 *
	 * @param key the key
	 * @return the performace
	 * @throws ParseException the parse exception
	 */
	public Person getPerformace(String key) throws ParseException{
		if(conn.exists(key)){
			Person person = new Person();
			Map<String, String> data = conn.hgetAll(key);
			person.setName(data.get("name"));
			DateFormat formatter = new SimpleDateFormat("MM/dd/yy");  
			person.setModifyDate(formatter.parse(data.get("modifyDate")));
			return person;
		}
		return null;
	}
}
