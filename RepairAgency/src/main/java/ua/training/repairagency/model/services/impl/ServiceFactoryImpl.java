package ua.training.repairagency.model.services.impl;

import ua.training.repairagency.model.services.interfaces.ServiceFactory;

public class ServiceFactoryImpl extends ServiceFactory {

	@Override
	public FetchUserByLoginService getFetchUserByLoginService() {
		return new FetchUserByLoginService();
	}

	@Override
	public InsertUserService getInsertUserService() {
		return new InsertUserService();
	}

	

	

}
