package ua.training.repairagency.model.services;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.utils.CommandUtils;
import ua.training.repairagency.model.dao.interfaces.UserDAO;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.entities.user.UserImpl;
import ua.training.repairagency.model.entities.user.UserRole;
import ua.training.repairagency.model.exceptions.NotUniqueFieldValueException;
import ua.training.repairagency.model.utils.DAOutils;

//TODO decide if implementation (and Service interface at all) needed
//TODO properly
public class CreateUserService extends AbstractService {
	
	HttpServletRequest request;
	
	public CreateUserService(HttpServletRequest request) {
		super();
		this.request = request;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User execute() throws NotUniqueFieldValueException {
		User user = new UserImpl();
		user.setRole(UserRole.valueOf(request.getParameter(ROLE)));
		user.setName(request.getParameter(NAME));
		user.setLogin(request.getParameter(REGISTRATION_LOGIN));
		user.setPassword(CommandUtils.doCrypt(request.getParameter(REGISTRATION_PASSWORD)));
		user.setEmail(request.getParameter(EMAIL));
		user.setPhone(request.getParameter(PHONE));	
		user.setApplications(null);
				
		try(UserDAO dao = daoFactory.createUserDAO()) {		
			return dao.create(user);				
		} catch (Exception e) {
			DAOutils.checkIfNotUniqueFieldValueException(e);
			return null;
		}		 
	}	
	
}
