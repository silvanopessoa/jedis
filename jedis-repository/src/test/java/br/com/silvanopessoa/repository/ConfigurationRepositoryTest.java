package br.com.silvanopessoa.repository;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;

public class ConfigurationRepositoryTest {

	@Test
	public void deveInserirValoreObter() {
		ConfigurationRepository repository = new ConfigurationRepository();
		String chave = "chave_"+UUID.randomUUID().toString();
		String valor = "valor_"+UUID.randomUUID().toString();
		repository.setValor(chave, valor);
		String valorObtido = repository.getValor(chave);
		assertNotNull(valorObtido);
		assertEquals(valorObtido, valor);
	}

}
