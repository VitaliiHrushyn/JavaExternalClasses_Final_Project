package ua.training.repairagency.model.services.impl;

import ua.training.repairagency.model.dao.DAOFactory;
import ua.training.repairagency.model.dao.interfaces.UserDAO;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.exceptions.NotUniqueFieldValueException;
import ua.training.repairagency.model.services.interfaces.UserService;
import ua.training.repairagency.model.utils.DAOutils;

public class UserServiceImpl implements UserService {
	
	DAOFactory daoFactory = DAOFactory.getInstance();

	@Override
	public User getUserByLogin(String login) {
		User user = null;
		try(UserDAO dao = daoFactory.createUserDAO()){
			user = dao.getByParam(login);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return user;
	}

	@Override
	public User insertUser(User user) throws NotUniqueFieldValueException {
		try(UserDAO dao = daoFactory.createUserDAO()) {		
			return dao.create(user);				
		} catch (Exception e) {
			DAOutils.checkIfNotUniqueFieldValueException(e);
			return null;
		}
	}

}
