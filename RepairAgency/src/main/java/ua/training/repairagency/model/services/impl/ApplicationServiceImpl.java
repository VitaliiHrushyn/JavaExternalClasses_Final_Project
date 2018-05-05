package ua.training.repairagency.model.services.impl;

import ua.training.repairagency.model.dao.DAOFactory;
import ua.training.repairagency.model.dao.interfaces.UserDAO;
import ua.training.repairagency.model.entities.application.AppStatus;
import ua.training.repairagency.model.entities.application.Application;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.services.interfaces.ApplicationService;

public class ApplicationServiceImpl implements ApplicationService {
	
	DAOFactory daoFactory = DAOFactory.getInstance();
	
	@Override
	public Application getAll() {
		return null;
	}

	@Override
	public Application getByUserId(int userId) {
		return null;
	}

	@Override
	public Application getByStatus(AppStatus atatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Application getByStatusAndUserId(AppStatus status, int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Application insert(Application application) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
