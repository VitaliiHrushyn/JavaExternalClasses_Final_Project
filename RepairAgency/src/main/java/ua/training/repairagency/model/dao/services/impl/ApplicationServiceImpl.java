package ua.training.repairagency.model.dao.services.impl;

import java.util.List;
import java.util.ResourceBundle;

import ua.training.repairagency.model.constants.Query;
import ua.training.repairagency.model.constants.Resource;
import ua.training.repairagency.model.dao.DAOFactory;
import ua.training.repairagency.model.dao.interfaces.ApplicationDAO;
import ua.training.repairagency.model.dao.services.interfaces.ApplicationService;
import ua.training.repairagency.model.entities.application.Application;

public class ApplicationServiceImpl implements ApplicationService {
	
	DAOFactory daoFactory = DAOFactory.getInstance();
	ResourceBundle queryBundle = ResourceBundle.getBundle(Resource.DB_QUERIES);
	
	@Override
	public List<Application> getAll() {
		try(ApplicationDAO dao = daoFactory.createApplicationDAO()) {		
			return dao.getAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
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
	public List<Application> getAllByStatuses(String... values) {
		String query = queryBundle.getString(Query.APPLICATION_GET_BY_STATUS);
	//	String[] values = getQueryValuesArray(3, statuses);
		try(ApplicationDAO dao = daoFactory.createApplicationDAO()) {			
			return dao.getAllByQuery(query, values);				
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Application insert(Application application) throws Exception {
		try(ApplicationDAO dao = daoFactory.createApplicationDAO()) {		
			return dao.create(application);				
		}
	}

	@Override
	public Application getById(int id) {
		try(ApplicationDAO dao = daoFactory.createApplicationDAO()){
			return dao.getById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}		
	}

	@Override
	public Application update(Application application) {
		try(ApplicationDAO dao = daoFactory.createApplicationDAO()){
			return dao.update(application);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}		
	}

	@Override
	public List<Application> getAllByUserIdAndStatuses(String... values) {
		
	//	String[] values = getQueryValuesArray(4, statuses);
		String query = queryBundle.getString(Query.APPLICATION_GET_BY_CUSTOMER_ID_AND_STATUS);
		
		try(ApplicationDAO dao = daoFactory.createApplicationDAO()) {			
			return dao.getAllByQuery(query, values);				
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Application> getAllById(int id) {
		try(ApplicationDAO dao = daoFactory.createApplicationDAO()) {		
			return dao.getAllByQuery(
					queryBundle.getString(Query.APPLICATION_GET_BY_ID), String.valueOf(id));				
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
//	private String[] getQueryValuesArray(String... statuses) {
//		String[] values = new String[quantity];
//	//	values[0] = String.valueOf(userId);
//		for (int i = 0; i < statuses.length; i++) {
//			values[i+1] = statuses[i];
//		}
//		return values;
//	}

}
