package ua.training.repairagency.model.dao.services.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import ua.training.repairagency.model.dao.services.ServiceFactory;
import ua.training.repairagency.model.dao.services.interfaces.UserService;

public class UserServiceImplTest {
	
	private UserService service;
	
	@Before
	public void setService() {
		service = ServiceFactory.getInstance().createUserService();
	}

	@Test
	public void testGetByLogin() {
		String login = "admin";		
		assertNotNull(service.getByLogin(login));
	}

	@Ignore
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetById() {
		int id = 79;		
		assertNotNull(service.getById(id));
	}

	@Ignore
	public void testUpdate() {
		fail("Not yet implemented");
	}

}
