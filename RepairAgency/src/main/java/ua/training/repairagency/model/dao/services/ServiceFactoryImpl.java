package ua.training.repairagency.model.dao.services;

import ua.training.repairagency.model.dao.services.impl.ApplicationServiceImpl;
import ua.training.repairagency.model.dao.services.impl.HistoryRecordServiceImpl;
import ua.training.repairagency.model.dao.services.impl.TestimonialServiceImpl;
import ua.training.repairagency.model.dao.services.impl.UserServiceImpl;
import ua.training.repairagency.model.dao.services.interfaces.ApplicationService;
import ua.training.repairagency.model.dao.services.interfaces.HistoryRecordService;
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
	public TestimonialService createTestimonialService() {
		return new TestimonialServiceImpl();
	}

	@Override
	public HistoryRecordService getHistoryRecordService() {
		return new HistoryRecordServiceImpl();
	}	

}
