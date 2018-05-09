package ua.training.repairagency.model.dao.services.impl;

import java.util.List;
import java.util.ResourceBundle;

import ua.training.repairagency.model.constants.Column;
import ua.training.repairagency.model.constants.Query;
import ua.training.repairagency.model.constants.Resource;
import ua.training.repairagency.model.dao.DAOFactory;
import ua.training.repairagency.model.dao.interfaces.ApplicationDAO;
import ua.training.repairagency.model.dao.services.interfaces.ApplicationService;
import ua.training.repairagency.model.entities.application.AppStatus;
import ua.training.repairagency.model.entities.application.Application;

public class ApplicationServiceImpl implements ApplicationService {
	
	DAOFactory daoFactory = DAOFactory.getInstance();
	ResourceBundle queryBundle = ResourceBundle.getBundle(Resource.DB_QUERIES);
	
	@Override
	public List<Application> getAll() {
		throw new RuntimeException();
	}

	@Override
	public List<Application> getAllByUserId(int userId) {
		try(ApplicationDAO dao = daoFactory.createApplicationDAO()) {		
			return dao.getAllByQuery(
					queryBundle.getString(Query.APPLICATION_GET_BY_CUSTOMER_ID), String.valueOf(userId));				
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Application> getByStatus(AppStatus atatus) {
		throw new RuntimeException();
	}

//	@Override
//	public List<Application> getAllByStatusAndUserId(AppStatus status, int userId) {
//		throw new RuntimeException();
//	}

	@Override
	public Application insert(Application application) throws Exception {
		try(ApplicationDAO dao = daoFactory.createApplicationDAO()) {		
			return dao.create(application);				
		}
	}

	@Override
	public Application getById(int id) {
		Application application = null;
		try(ApplicationDAO dao = daoFactory.createApplicationDAO()){
			application = dao.getById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}		
		return application;
	}

	@Override
	public Application update(Application application) {
		try(ApplicationDAO dao = daoFactory.createApplicationDAO()){
			application = dao.update(application);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}		
		return application;
	}

	@Override
	public List<Application> getAllByUserIdAndStatuses(int userId, String... statuses) {
		String[] values = new String[4];
		values[0] = String.valueOf(userId);
		for (int i = 0; i < statuses.length; i++) {
			values[i+1] = statuses[i];
		}
		try(ApplicationDAO dao = daoFactory.createApplicationDAO()) {			
			return dao.getAllByQuery(
					queryBundle.getString(Query.APPLICATION_GET_BY_CUSTOMER_ID_AND_STATUS), values);				
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
