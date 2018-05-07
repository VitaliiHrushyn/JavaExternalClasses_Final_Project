package ua.training.repairagency.model.dao.services.interfaces;

import ua.training.repairagency.model.dao.services.impl.ServiceFactoryImpl;

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
	public abstract TestimonialService getTestimonialService();
	public abstract HistoryRecordService getHistoryRecordService();
	
}
