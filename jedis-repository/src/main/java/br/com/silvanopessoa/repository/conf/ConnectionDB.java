package br.com.silvanopessoa.repository.conf;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * The Class ConnectionDB.
 */
public class ConnectionDB {
	
	/** The host. */
	private String host = "localhost"; 

	/** The port. */
	private int port = 6379; 

	
	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public Jedis getConnection(){
		return new Jedis(this.host, this.port);
	}
	
	/**
	 * Gets the connection.
	 *
	 * @param host the host
	 * @param port the port
	 * @return the connection
	 */
	public Jedis getConnection(String host, int port){
		return new Jedis(host, port);
	}
	
	/**
	 * Gets the connection.
	 *
	 * @param host the host
	 * @param port the port
	 * @param timeout the timeout
	 * @return the connection
	 */
	public Jedis getConnection(String host, int port, int timeout){
		return new Jedis(host, port, timeout);
	}
	
	/**
	 * Gets the jedis pool.
	 *
	 * @param host the host
	 * @param port the port
	 * @return the jedis pool
	 */
	public JedisPool getJedisPool(String host, int port){
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMinIdle(5);
		config.setMaxIdle(15);
		config.setMaxTotal(15);
		return new JedisPool(config,host,port);
	}
}
