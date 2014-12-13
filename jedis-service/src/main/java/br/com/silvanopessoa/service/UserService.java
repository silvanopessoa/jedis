package br.com.silvanopessoa.service;

import static br.com.silvanopessoa.model.transformation.ObjectToSerializableAssembler.objectToBytes;
import static br.com.silvanopessoa.model.transformation.SerializableToObjectAssembler.bytesToObject;

import java.io.IOException;

import br.com.silvanopessoa.jedis.model.User;
import br.com.silvanopessoa.repository.UserRepository;

/**
 * The Class UserService.
 */
public class UserService {

	/** The repository. */
	private UserRepository repository;
	
	/**
	 * Instantiates a new user service.
	 */
	public UserService() {
		repository = new UserRepository();
	}
	
	/**
	 * Sets the user.
	 *
	 * @param key the key
	 * @param user the user
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void setUser(String key, User user) throws IOException{
		byte[]  userSerializable = objectToBytes(user);
		repository.setUser(key, userSerializable);
	}
	
	/**
	 * Gets the user.
	 *
	 * @param key the key
	 * @return the user
	 * @throws ClassNotFoundException the class not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public User getUser(String key) throws ClassNotFoundException, IOException{
		byte[] user = repository.getUser(key);
		return (User) bytesToObject(user);
	}
	
}
