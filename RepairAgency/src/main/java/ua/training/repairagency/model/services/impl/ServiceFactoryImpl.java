package ua.training.repairagency.model.services.impl;

import ua.training.repairagency.model.services.interfaces.ServiceFactory;
import ua.training.repairagency.model.services.interfaces.UserService;

public class ServiceFactoryImpl extends ServiceFactory {

	@Override
	public UserService getUserService() {
		return new UserServiceImpl();
	}	

}
