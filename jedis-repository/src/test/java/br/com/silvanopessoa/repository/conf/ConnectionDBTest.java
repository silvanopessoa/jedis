package br.com.silvanopessoa.repository.conf;

import static org.junit.Assert.*;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class ConnectionDBTest {

	@Test
	public void deveObterUmaConexaoeInserirUmaChave() {
		ConnectionDB conn = new ConnectionDB();
		Jedis conexaoSimples = conn.getConnection("127.0.0.1", 6379);
		conexaoSimples.set("teste", "Ola Mundo!");
		assertNotNull(conexaoSimples.get("teste"));
	}

	@Test
	public void deveObterUmaConexaoPooleInserirUmaChaveDevolverConexao() {
		ConnectionDB conn = new ConnectionDB();
		JedisPool conexao = conn.getJedisPool("127.0.0.1", 6379);

		Jedis conexaoPool = null;
		try {
			conexaoPool = conexao.getResource();
			conexaoPool.set("testePool", "Ola Mundo com Pool!");
			assertNotNull(conexaoPool.get("teste"));
		} finally {
			conexao.returnResource(conexaoPool);
		}

	}

}
