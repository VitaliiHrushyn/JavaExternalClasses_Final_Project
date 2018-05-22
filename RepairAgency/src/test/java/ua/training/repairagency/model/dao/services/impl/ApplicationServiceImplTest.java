package ua.training.repairagency.model.dao.services.impl;

import static org.junit.Assert.*;
import static ua.training.repairagency.controller.constants.AttributeOrParam.APPROVED_APPLICATION;
import static ua.training.repairagency.controller.constants.AttributeOrParam.EXECUTING_APPLICATION;
import static ua.training.repairagency.controller.constants.AttributeOrParam.RECEIVED_APPLICATION;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import ua.training.repairagency.model.constants.Query;
import ua.training.repairagency.model.dao.services.ServiceFactory;
import ua.training.repairagency.model.dao.services.interfaces.ApplicationService;
import ua.training.repairagency.model.entities.application.Application;

public class ApplicationServiceImplTest {
	
	private ApplicationService service;
	
	@Before
	public void setService() {
		service = ServiceFactory.getInstance().createApplicationService();
	}

	@Test
	public void testGetNumberOfPagesByQuery() {
		String[] values = {EXECUTING_APPLICATION, APPROVED_APPLICATION, RECEIVED_APPLICATION};
		Integer pageNumber = service.getNumberOfPagesByQuery(Query.APPLICATION_COUNT_BY_STATUS, values);
		assertNotNull(pageNumber);
	}

	@Test
	public void testGetAll() {
		int pageNumber = 1;
		List<Application> applications = service.getAll(pageNumber);
		assertNotNull(applications);
	}

	@Ignore
	public void testGetAllByUserId() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testGetAllByStatuses() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testGetById() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testGetAllByCustomerIdAndStatuses() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testGetAllByWorkmanIdAndStatuses() {
		fail("Not yet implemented");
	}

}
