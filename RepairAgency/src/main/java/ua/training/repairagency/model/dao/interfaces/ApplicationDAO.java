package ua.training.repairagency.model.dao.interfaces;

import java.util.List;

import ua.training.repairagency.model.entities.application.Application;

public interface ApplicationDAO extends GenericDAO<Application> {
	
	List<Application> getAllByQuery(String query, String... values);

}
