package ua.training.repairagency.model.services.impl;

import ua.training.repairagency.model.services.interfaces.ApplicationService;
import ua.training.repairagency.model.services.interfaces.HistoryRecordService;
import ua.training.repairagency.model.services.interfaces.ServiceFactory;
import ua.training.repairagency.model.services.interfaces.TestimonialService;
import ua.training.repairagency.model.services.interfaces.UserService;

public class ServiceFactoryImpl extends ServiceFactory {

	@Override
	public UserService createUserService() {
		return new UserServiceImpl();
	}

	@Override
	public ApplicationService getApplicationService() {
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
