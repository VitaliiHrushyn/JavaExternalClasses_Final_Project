package ua.training.repairagency.model.dao.services.impl;

import java.util.List;

import ua.training.repairagency.model.constants.Column;
import ua.training.repairagency.model.dao.DAOFactory;
import ua.training.repairagency.model.dao.interfaces.ApplicationDAO;
import ua.training.repairagency.model.dao.services.interfaces.ApplicationService;
import ua.training.repairagency.model.entities.application.AppStatus;
import ua.training.repairagency.model.entities.application.Application;

public class ApplicationServiceImpl implements ApplicationService {
	
	DAOFactory daoFactory = DAOFactory.getInstance();
	
	@Override
	public List<Application> getAll() {
		return null;
	}

	@Override
	public List<Application> getAllByUserId(int userId) {
		try(ApplicationDAO dao = daoFactory.createApplicationDAO()) {		
			return dao.getAllByParam(Column.APPLICATION_CUSTOMER_ID, String.valueOf(userId));				
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Application> getByStatus(AppStatus atatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Application> getByStatusAndUserId(AppStatus status, int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Application insert(Application application) throws Exception {
		try(ApplicationDAO dao = daoFactory.createApplicationDAO()) {		
			return dao.create(application);				
		}
	}

}
