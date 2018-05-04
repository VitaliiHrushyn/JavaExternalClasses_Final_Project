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
	
//	public abstract Service createGetAllAppsService();
//	public abstract Service createGetAllWorkmenService();
	
	public abstract FetchUserByLogin getFetchUserByLoginService();
	public abstract InsertUser getInsertUserService();
	


}
