package ua.training.repairagency.model.services.interfaces;

import ua.training.repairagency.model.services.impl.ServiceFactoryImpl;

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

	public abstract UserService getUserService();
	public abstract ApplicationService getApplicationService();
	public abstract TestimonialService getTestimonialService();
	public abstract HistoryRecordService getHistoryRecordService();
	
}
