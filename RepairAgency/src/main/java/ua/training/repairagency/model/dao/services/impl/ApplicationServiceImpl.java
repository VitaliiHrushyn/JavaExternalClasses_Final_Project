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
	public int getNumberOfPagesByQuery(String query, String... values) {
		try(ApplicationDAO dao = daoFactory.createApplicationDAO()) {
			int totalRowsCount = dao.coutnRowsByQuery(query, values);
			return (int) Math.ceil(totalRowsCount / (double) Query.ROWS_PER_PAGE);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public List<Application> getAll(int pageNumber) {
		try(ApplicationDAO dao = daoFactory.createApplicationDAO()) {
			int limit = Query.ROWS_PER_PAGE;
			int offset = limit * (pageNumber - 1);
			return dao.getAll(limit, offset);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Application> getAllByUserId(int pageNumber, int userId) {
		String[] values = getQueryValuesArray(pageNumber, String.valueOf(userId));
		try(ApplicationDAO dao = daoFactory.createApplicationDAO()) {		
			return dao.getAllByQueryWithLimitAndOffset(
					queryBundle.getString(Query.APPLICATION_GET_BY_CUSTOMER_ID), values);				
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Application> getAllByStatuses(int pageNumber, String... statuses) {
		String[] values = getQueryValuesArray(pageNumber, statuses);
		String query = queryBundle.getString(Query.APPLICATION_GET_BY_STATUS);
		try(ApplicationDAO dao = daoFactory.createApplicationDAO()) {			
			return dao.getAllByQueryWithLimitAndOffset(query, values);				
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
	public List<Application> getAllByCustomerIdAndStatuses(int pageNumber, String... statuses) {
		String[] values = getQueryValuesArray(pageNumber, statuses);
		String query = queryBundle.getString(Query.APPLICATION_GET_BY_CUSTOMER_ID_AND_STATUSES);
		
		try(ApplicationDAO dao = daoFactory.createApplicationDAO()) {			
			return dao.getAllByQueryWithLimitAndOffset(query, values);				
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	@Override
	public List<Application> getAllByWorkmanIdAndStatuses(int pageNumber, String... statuses) {
		String query = queryBundle.getString(Query.APPLICATION_GET_BY_WORKMAN_ID_AND_STATUSES);		
		String[] values = getQueryValuesArray(pageNumber, statuses);
		try(ApplicationDAO dao = daoFactory.createApplicationDAO()) {			
			return dao.getAllByQueryWithLimitAndOffset(query, values);				
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	private String[] getQueryValuesArray(int pageNumber, String... statuses) {
		String[] values = new String[statuses.length + 2];
		for (int i = 0; i < statuses.length; i++) {
			values[i] = statuses[i];
		}
		int limit = Query.ROWS_PER_PAGE;
		int offset = limit * (pageNumber - 1);
		values[values.length-2] = String.valueOf(limit);
		values[values.length-1] = String.valueOf(offset);
		return values;
	}

}
