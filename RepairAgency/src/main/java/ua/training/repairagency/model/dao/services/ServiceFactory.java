package ua.training.repairagency.model.dao.services;

import ua.training.repairagency.model.dao.services.interfaces.ApplicationService;
import ua.training.repairagency.model.dao.services.interfaces.HistoryRecordService;
import ua.training.repairagency.model.dao.services.interfaces.TestimonialService;
import ua.training.repairagency.model.dao.services.interfaces.UserService;

public abstract class ServiceFactory {
	
	private static ServiceFactory serviceFactory;
	
	public static ServiceFactory getInstance() {
		if (serviceFactory == null) {
			synchronized (ServiceFactory.class) {
				if (serviceFactory == null) {
					ServiceFactory temp = new ServiceFactoryImpl();
					serviceFactory = temp;
				}				
			}
		}
		return serviceFactory;
	}

	public abstract UserService createUserService();
	public abstract ApplicationService createApplicationService();
	public abstract TestimonialService createTestimonialService();
	public abstract HistoryRecordService getHistoryRecordService();
	
}
