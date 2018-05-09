package ua.training.repairagency.model.utils;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;

import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.entities.user.UserImpl;
import ua.training.repairagency.model.entities.user.UserRole;

public class UserUtils {
	
	public static String doCrypt(String string) {
		return DigestUtils.md5Hex(string.getBytes());
	}
	
	public static User createUser(HttpServletRequest request) {
		User user = new UserImpl();
		user.setRole(UserRole.valueOf(request.getParameter(ROLE)));
		user.setName(request.getParameter(NAME));
		user.setSurname(request.getParameter(SURNAME));
		user.setLogin(request.getParameter(REGISTRATION_LOGIN));
		user.setPassword(doCrypt(request.getParameter(REGISTRATION_PASSWORD)));
		user.setEmail(request.getParameter(EMAIL));
		user.setPhone(request.getParameter(PHONE));	
		
		return user;
	}
	
	public static User updateUserFeatures(User user, HttpServletRequest request) {
		user.setName(request.getParameter(NAME));
		user.setSurname(request.getParameter(SURNAME));
		user.setLogin(request.getParameter(LOGIN));
		user.setEmail(request.getParameter(EMAIL));
		user.setPhone(request.getParameter(PHONE));	
		
		return user;
	}

}
