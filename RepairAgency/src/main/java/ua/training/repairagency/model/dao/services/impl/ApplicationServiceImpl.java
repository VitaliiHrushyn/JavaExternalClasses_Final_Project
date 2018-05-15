package ua.training.repairagency.model.dao.services.impl;

import java.util.List;
import java.util.ResourceBundle;

import ua.training.repairagency.model.constants.Query;
import ua.training.repairagency.model.constants.Resource;
import ua.training.repairagency.model.dao.DAOFactory;
import ua.training.repairagency.model.dao.interfaces.ApplicationDAO;
import ua.training.repairagency.model.dao.services.interfaces.ApplicationService;
import ua.training.repairagency.model.entities.application.Application;
import ua.training.repairagency.model.exceptions.OutOfDateDataException;

public class ApplicationServiceImpl implements ApplicationService {
	
	DAOFactory daoFactory = DAOFactory.getInstance();
	ResourceBundle queryBundle = ResourceBundle.getBundle(Resource.DB_QUERIES);
	
	@Override
	public List<Application> getAll() {
		try(ApplicationDAO dao = daoFactory.createApplicationDAO()) {
			int totalRowsCount = dao.coutnRows();
//			System.out.println("service rows: " + totalRowsCount);
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
	public Application update(Application application) throws OutOfDateDataException {
		try(ApplicationDAO dao = daoFactory.createApplicationDAO()) {
				return dao.update(application); 		
		} catch (Exception e) {
			if (e.getClass().equals(OutOfDateDataException.class)) {
				throw new OutOfDateDataException(e);
			} else {
				throw new RuntimeException(e);
			}
		}		
	}

	@Override
	public List<Application> getAllByCustomerIdAndStatuses(String... values) {
		
	//	String[] values = getQueryValuesArray(4, statuses);
		String query = queryBundle.getString(Query.APPLICATION_GET_BY_CUSTOMER_ID_AND_STATUSES);
		
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

	@Override
	public List<Application> getAllByWorkmanIdAndStatuses(String... values) {
		String query = queryBundle.getString(Query.APPLICATION_GET_BY_WORKMAN_ID_AND_STATUSES);
		
		try(ApplicationDAO dao = daoFactory.createApplicationDAO()) {			
			return dao.getAllByQuery(query, values);				
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
