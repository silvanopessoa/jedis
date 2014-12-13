package br.com.silvanopessoa.repository;

import redis.clients.jedis.Jedis;
import br.com.silvanopessoa.repository.conf.ConnectionDB;

/**
 * The Class ConfigurationRepository.
 */
public class UsuarioRepository {

	/** The conn. */
	private Jedis conn;

	/**
	 * Instantiates a new configuration repository.
	 */
	public UsuarioRepository() {
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

	/**
	 * Append.
	 *
	 * @param key the key
	 * @param value the value
	 */
	public void append(String key, String value){
		conn.append(key, value);
	}

	/**
	 * Incrementar chave.
	 *
	 * @param key the key
	 */
	public long incrKey(String key){
		return conn.incr(key);
	}
	
	/**
	 * Incr by chave and value.
	 *
	 * @param key the key
	 * @param value the value
	 * @return the long
	 */
	public long incrKeyByChaveAndValue(String key, long value){
		return conn.incrBy(key, value);
	}
	
	/**
	 * Str len.
	 *
	 * @param key the key
	 * @return the long
	 */
	public long strLen(String key){
		return conn.strlen(key);
	}
	
}
