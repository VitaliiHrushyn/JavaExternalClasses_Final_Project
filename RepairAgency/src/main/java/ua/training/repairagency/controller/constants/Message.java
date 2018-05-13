package ua.training.repairagency.controller.constants;

public interface Message {
		
	String BUNDLE_NAME = "locale/messages";
	
	String AUTH_FAIL = "message.auth.fail";
	String LOGIN_EMPTY = "message.login.empty";	
	String LOGIN_FAIL_MESSAGE = "message.auth.fail";	
	String REGISTRATION_EMPTY = "message.registration.empty";
//	String USER_ALREADY_LOGGINED = "message.user.already.loggined";
	
	String NOT_UNIQUE_LOGIN ="message.not.unique.login";
	String NOT_UNIQUE_EMAIL ="message.not.unique.email";
	String NOT_UNIQUE_PHONE ="message.not.unique.phone";
	
	String LOGIN_INVALID = "message.login.invalid";
	String PASSWORD_INVALID = "message.password.invalid";
	String CONFIRMPASSWORD_INVALID = "message.confirmpassword.invalid";
	String NAME_INVALID = "message.name.invalid";
	String SURNAME_INVALID = "message.surname.invalid";
	String EMAIL_INVALID = "message.email.invalid";
	String PHONE_INVALID = "message.phone.invalid";
	String POINT = "message.comma";
	
	String UPDATE_USER_SUCCESS = "message.update.user.saccess";
	String DELETE_USER_SUCCESS = "message.delete.user.saccess";
	String APPLICATION_CREATE_SUCCESS = "message.create.application.success";
	String APPLICATION_CREATE_FAIL = "message.create.application.fail";
	String APPLICATION_UPDATE_SUCCESS = "message.update.application.success";

	String USER_CREAT_SUCCESS = "message.create.user.success";

	String ERROR_EMPTY_COMMENT = "error.app.empty.comment";
	String ERROR_EMPTY_PRICE = "error.app.empty.price";
	String ERROR_EMPTY_WORKMAN = "error.app.empty.workman";

	
	
}
