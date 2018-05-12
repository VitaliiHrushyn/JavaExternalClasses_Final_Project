package ua.training.repairagency.controller.utils;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.constants.*;
import ua.training.repairagency.model.exceptions.NotUniqueFieldValueException;

public class CommandUtils {
	
	private static final Logger authLogger = Logger.getLogger(Command.class);
	
	public static String getFailMessageFromException(NotUniqueFieldValueException e) {
		String exceptionErrorMessage = e.getMessage();
		String message = null;
		if (exceptionErrorMessage.contains(AttributeOrParam.LOGIN)) {
			message = Message.NOT_UNIQUE_LOGIN;
		}
		if (exceptionErrorMessage.contains(AttributeOrParam.EMAIL)) {
			message = Message.NOT_UNIQUE_EMAIL;
		}
		if (exceptionErrorMessage.contains(AttributeOrParam.PHONE)) {
			message = Message.NOT_UNIQUE_PHONE;
		}		
		return message;
	}
	
	/*
	 * If request doesn't contain param "language" this param is got from session.
	 * It isn't possible to get param "language" from session every time, 
	 * because session fall behind by one step when language is changed on jsp page,
	 * so it is necessary (in session case) reload (F5) page every time after change language.
	 * When request doesn't contain param "language" it is also impossible to use default language, 
	 * because every time when page with language feature is used request looses language param 
	 * and default language instead of chosen one is set.
	 * When session also is null - set language from browser (from request), 
	 * if system doesn't have such language locale - is used default locale.
	 * @param request
	 * @return Locale
	 */
	public static Locale getLocale(HttpServletRequest request) {
		HttpSession session = request.getSession();			
		String language;
		if (request.getParameter("language") != null) {
			language = request.getParameter("language");
		}
		else if (session.getAttribute("language") != null) {
			language = session.getAttribute("language").toString();
		}
		else {
			language = request.getLocale().getLanguage();
			session.setAttribute("language", language);			
		}		
		return new Locale(language);
	}
	
	public static boolean checkRegistrationCredentials(HttpServletRequest request, List<String> messages) {
		
		/*
		 * when reload registration page - sends null in all parameters,
		 * to avoid exception is enough to check first param by null
		 * and return from method
		 */
		if (!isRequestContains(request, AttributeOrParam.LOGIN)) {
			return false;
		}
		
		ResourceBundle regexBundle = ResourceBundle.getBundle(RegEx.BUNDLE_NAME, getLocale(request));
		ResourceBundle messageBundle = ResourceBundle.getBundle(Message.BUNDLE_NAME, getLocale(request));
	
		String login = request.getParameter(LOGIN);
		String password = (request.getParameter(PASSWORD));
		String confirmpassword = request.getParameter(CONFIRM_PASSWORD);
		String name = request.getParameter(NAME);
		String surname = request.getParameter(SURNAME);
		String email = request.getParameter(EMAIL);
		String phone = request.getParameter(PHONE);
		
		boolean check = true;
				
		if (!login.matches(regexBundle.getString(RegEx.LOGIN))) {
			messages.add(messageBundle.getString(Message.LOGIN_INVALID));
			check = false;
		}
		if (!password.matches(regexBundle.getString(RegEx.PASSWORD))) {
			messages.add(messageBundle.getString(Message.PASSWORD_INVALID));
			check = false;
		}
		if (!confirmpassword.equals(password)) {
			messages.add(messageBundle.getString(Message.CONFIRMPASSWORD_INVALID));
			check = false;
		}
		if (!name.matches(regexBundle.getString(RegEx.NAME))) {
			messages.add(messageBundle.getString(Message.NAME_INVALID));
			check = false;
		}
		if (!surname.matches(regexBundle.getString(RegEx.SURNAME))) {
			messages.add(messageBundle.getString(Message.SURNAME_INVALID));
			check = false;
		}
		if (!email.matches(regexBundle.getString(RegEx.EMAIL))) {
			messages.add(messageBundle.getString(Message.EMAIL_INVALID));
			check = false;
		}
		if (!phone.matches(regexBundle.getString(RegEx.PHONE))){
			messages.add(messageBundle.getString(Message.PHONE_INVALID));
			check = false;
		}

		return check;
	}

	public static boolean isRequestContains(HttpServletRequest request, String param) {
		return request.getParameter(param) != null;
	}

	public static boolean checkLoginCredentials(HttpServletRequest request, List<String> messages) {

		if (!isRequestContains(request, AttributeOrParam.LOGIN)) {
			return false;
		}
		
		ResourceBundle regexBundle = ResourceBundle.getBundle(RegEx.BUNDLE_NAME, getLocale(request));
		ResourceBundle messageBundle = ResourceBundle.getBundle(Message.BUNDLE_NAME, getLocale(request));
		String login = request.getParameter(LOGIN);
		String password = (request.getParameter(PASSWORD));
				
		if ( !login.matches(regexBundle.getString(RegEx.LOGIN)) ||
			 !password.matches(regexBundle.getString(RegEx.PASSWORD)) ) {
			messages.add(messageBundle.getString(Message.AUTH_FAIL));
			authLogger.info("Login FAIL: login or password don't match RegEx: "
					+ "login=" + login +", password=" + password + ";");
			return false;
		} else {
			return true;
		}		
	}

}
