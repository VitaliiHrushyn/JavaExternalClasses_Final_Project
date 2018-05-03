package ua.training.repairagency.model.services;


import ua.training.repairagency.model.dao.DAOFactory;
import ua.training.repairagency.model.exceptions.NotUniqueFieldValueException;

public abstract class AbstractService implements Service {
	
	DAOFactory daoFactory = DAOFactory.getInstance();
		
	@Override
	public abstract <T> T execute() throws NotUniqueFieldValueException;

}
