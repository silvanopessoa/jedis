package br.com.silvanopessoa.repository;

import redis.clients.jedis.Jedis;
import br.com.silvanopessoa.repository.conf.ConnectionDB;

/**
 * The Class ConfigurationRepository.
 */
public class UserRepository {

	/** The conn. */
	private Jedis conn;

	/**
	 * Instantiates a new configuration repository.
	 */
	public UserRepository() {
		this.conn = new ConnectionDB().getConnection();
	}

	/**
	 * Gets the user.
	 *
	 * @param key the key
	 * @return the user
	 */
	public byte[] getUser(String key) {
		return conn.get(key.getBytes());
	}
	
	/**
	 * Sets the user.
	 *
	 * @param key the key
	 * @param user the user
	 */
	public void setUser(String key, byte[] user) {
		conn.set(key.getBytes(),user);
	}
	
}
