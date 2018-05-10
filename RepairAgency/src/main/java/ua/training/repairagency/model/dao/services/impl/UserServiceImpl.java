package ua.training.repairagency.model.dao.services.impl;

import ua.training.repairagency.model.dao.DAOFactory;
import ua.training.repairagency.model.dao.interfaces.UserDAO;
import ua.training.repairagency.model.dao.services.interfaces.UserService;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.exceptions.NotUniqueFieldValueException;
import ua.training.repairagency.model.utils.DAOutils;

public class UserServiceImpl implements UserService {
	
	DAOFactory daoFactory = DAOFactory.getInstance();
	
	@Override
	public User getByLogin(String login) {
		try(UserDAO dao = daoFactory.createUserDAO()){
			return dao.getByLogin(login);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
	}

	@Override
	public User insert(User user) throws NotUniqueFieldValueException {
		try(UserDAO dao = daoFactory.createUserDAO()) {		
			return dao.create(user);				
		} catch (Exception e) {
			DAOutils.checkIfNotUniqueFieldValueException(e);
			return null;
		}
	}

	@Override
	public User getById(int userId) {
		try(UserDAO dao = daoFactory.createUserDAO()){
			return dao.getById(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
	}

	@Override
	public User update(User user) throws NotUniqueFieldValueException {
		try(UserDAO dao = daoFactory.createUserDAO()){
			user = dao.update(user);
		} catch (Exception e) {
			DAOutils.checkIfNotUniqueFieldValueException(e);
			return null;
		}		
		return user;
	}

}
