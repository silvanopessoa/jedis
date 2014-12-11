package br.com.silvanopessoa.repository;

import redis.clients.jedis.Jedis;
import br.com.silvanopessoa.repository.conf.ConnectionDB;

/**
 * The Class ConfigurationRepository.
 */
public class ConfigurationRepository {

	/** The conn. */
	private Jedis conn;

	/**
	 * Instantiates a new configuration repository.
	 */
	public ConfigurationRepository() {
		this.conn = new ConnectionDB().getConnection();
	}

	/**
	 * Gets the valor.
	 *
	 * @param key the key
	 * @return the valor
	 */
	public String getValor(String key) {
		return conn.get(key);
	}
	
	/**
	 * Sets the valor.
	 *
	 * @param key the key
	 * @param value the value
	 */
	public void setValor(String key, String value) {
		conn.set(key,value);
	}

	
}
