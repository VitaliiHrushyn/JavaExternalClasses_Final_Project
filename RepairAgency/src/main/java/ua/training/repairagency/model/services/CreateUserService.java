package ua.training.repairagency.model.services;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.model.dao.DAOFactory;
import ua.training.repairagency.model.dao.interfaces.UserDAO;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.entities.user.UserImpl;
import ua.training.repairagency.model.entities.user.UserRole;
import ua.training.repairagency.model.exceptions.NotUniqueParamException;

//TODO decide if implementation (and Service interface at all) needed
//TODO properly
public class CreateUserService implements Service {

	public User execute(HttpServletRequest request) {
		//TODO delete stub
		User user = new UserImpl();
		user.setRole(UserRole.valueOf(request.getParameter("role")));
		user.setName(request.getParameter("name"));
		user.setLogin(request.getParameter("reglogin"));
		user.setPassword((String)request.getParameter("regpassword"));
		user.setEmail(request.getParameter("email"));
		user.setPhone(request.getParameter("phone"));	
		user.setApplications(null);
				
		User insertedUser = null;
		try(UserDAO dao = DAOFactory.getInstance().createUserDAO()){
			insertedUser = dao.create(user);
		} catch (NotUniqueParamException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getClass().toString());
		}		
		return insertedUser;
	}
}
