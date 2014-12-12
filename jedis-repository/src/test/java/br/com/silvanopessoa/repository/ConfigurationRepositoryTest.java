package br.com.silvanopessoa.repository;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

public class ConfigurationRepositoryTest {

	private ConfigurationRepository repository;
	
	@Before
	public void init(){
		repository = new ConfigurationRepository();
	}
	
	@Test
	public void deveInserirValoreObter() {
		String chave = "chave_"+UUID.randomUUID().toString();
		String valor = "valor_"+UUID.randomUUID().toString();
		repository.setValor(chave, valor);
		String valorObtido = repository.getValor(chave);
		assertNotNull(valorObtido);
		assertEquals(valorObtido, valor);
	}
	
	@Test
	public void deveConcatenarUmaString() {
		String chave = "chave_"+UUID.randomUUID().toString();
		String valor = "A";
		repository.setValor(chave, valor);
		String valorObtido = repository.getValor(chave);
		assertNotNull(valorObtido);
		assertEquals(valorObtido, valor);
		repository.append(chave, "B");
		String valorObtidoAppend = repository.getValor(chave);
		assertNotNull(valorObtido);
		assertEquals(valor+"B",valorObtidoAppend);
	}
	
	@Test
	public void deveIncrementarUmaChave(){
		String chave = UUID.randomUUID().toString();
		System.out.println(chave);
		assertEquals(1l, repository.incrKey(chave));
		assertEquals(2l, repository.incrKey(chave));
	}
	
	@Test
	public void deveIncrementarChavePassandoValor(){
		String chave = UUID.randomUUID().toString();
		System.out.println(chave);
		assertEquals(1l, repository.incrKey(chave));
		assertEquals(26l, repository.incrKeyByChaveAndValue(chave, 25));
	}
	
	@Test
	public void deveRetornarTamanhoDoValor(){
		String valor = UUID.randomUUID().toString();
		String chave = UUID.randomUUID().toString();
		long tamanho =  chave.length();
		repository.setValor(chave,valor);
		assertEquals(tamanho, repository.strLen(chave));
	}

}
