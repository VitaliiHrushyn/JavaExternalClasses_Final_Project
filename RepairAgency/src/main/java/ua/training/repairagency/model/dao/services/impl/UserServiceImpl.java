package ua.training.repairagency.model.dao.services.impl;

import ua.training.repairagency.model.constants.Column;
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
		User user = null;
		try(UserDAO dao = daoFactory.createUserDAO()){
			user = dao.getByLogin(login);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return user;
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
		User user = null;
		try(UserDAO dao = daoFactory.createUserDAO()){
			user = dao.getById(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return user;
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
