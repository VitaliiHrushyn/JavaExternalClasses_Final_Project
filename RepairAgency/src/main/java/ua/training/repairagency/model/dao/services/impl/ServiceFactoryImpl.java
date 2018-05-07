package ua.training.repairagency.model.dao.services.impl;

import ua.training.repairagency.model.dao.services.interfaces.ApplicationService;
import ua.training.repairagency.model.dao.services.interfaces.HistoryRecordService;
import ua.training.repairagency.model.dao.services.interfaces.ServiceFactory;
import ua.training.repairagency.model.dao.services.interfaces.TestimonialService;
import ua.training.repairagency.model.dao.services.interfaces.UserService;

public class ServiceFactoryImpl extends ServiceFactory {

	@Override
	public UserService createUserService() {
		return new UserServiceImpl();
	}

	@Override
	public ApplicationService createApplicationService() {
		return new ApplicationServiceImpl();
	}

	@Override
	public TestimonialService getTestimonialService() {
		return new TestimonialServiceImpl();
	}

	@Override
	public HistoryRecordService getHistoryRecordService() {
		return new HistoryRecordServiceImpl();
	}	

}
