package br.com.silvanopessoa.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import br.com.silvanopessoa.jedis.model.User;

public class UserServiceTest {

	
	private UserService service;
	
	@Before
	public void init(){
		service = new UserService();
	}
	
	private User generateUser(){
		User user = new User();
		user.setLogin("silvano.pessoa");
		user.setId(32l);
		user.setModifyDate(new Date());
		return user;
	}
	
	
	@Test
	public void deveSalvarUmObjetoSerializado() throws IOException, ClassNotFoundException{
		User generateUser = this.generateUser();
		service.setUser("silvano", generateUser);
		User user = service.getUser("silvano");
		assertNotNull(user);
		assertEquals(generateUser.getLogin(), user.getLogin());
	}

}
