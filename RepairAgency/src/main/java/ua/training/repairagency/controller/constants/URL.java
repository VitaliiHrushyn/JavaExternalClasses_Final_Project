package ua.training.repairagency.controller.constants;

public interface URL {
	
	
	/*
	 * COMMON
	 */
	String PAGE_404 = "/WEB-INF/404.jsp";
	String LOGIN_PAGE = "/WEB-INF/default/login/login.jsp";
	String INDEX_PAGE = "/WEB-INF/default/index/index.jsp";
	String REGISTRATION_PAGE = "/WEB-INF/default/registration/registration.jsp";
	String REDIRECT_LOGIN_COMMAND = "redirect:/app/login";
	String REDIRECT_INDEX_COMMAND = "redirect:/app/index";
	String INDEX_COMMAND = "/app/index";
	String LOGIN_COMMAND = "/app/login";
	String LOGOUT_COMMAND = "/app/logout";
	String ERROR_404_COMMAND = "/app/404";
	String REDIRECT_ERROR_404_COMMAND = "redirect:/app/404";
	String REGISTRATION_COMMAND = "/app/registration";
	
	String SERVLET_PATTERN = "/app/*";
	String CONTEXT_ADDON = "/app/";
	String EMPTY = "";
	String REDIRECT = "redirect:";
	String LOGOUT = "logout";
	String LOGIN = "login";
	String INDEX = "index";
	String REGISTRATION = "registration";
	String ERROR_404 = "404";
	
	String COMMON_URL = "/WEB-INF/common/";

	
	/* 
	 * customer 
	 */
	String CUSTOMER_URL = "/WEB-INF/roles/customer/";
	// /RepairAgency/src/main/webapp/WEB-INF/common/applications/one_app.jsp
	
	String CUSTOMER_PROFILE_PAGE = COMMON_URL + "profile/profile.jsp";
	String CUSTOMER_EDITPROFILE_PAGE = COMMON_URL + "profile/editprofile.jsp";	
	String CUSTOMER_APPLICATION_SHOW_PAGE = COMMON_URL + "applications/show_to_one.jsp";
	String CUSTOMER_APPLICATION_ONE_PAGE = COMMON_URL + "applications/one_app.jsp";
	String CUSTOMER_APPLICATION_RECEIVED_PAGE = COMMON_URL + "applications/show_to_approve.jsp";
	String CUSTOMER_APPLICATION_DONE_PAGE = COMMON_URL + "applications/show_to_finish.jsp";
	
	String CUSTOMER_APPLICATION_INDEX_PAGE = CUSTOMER_URL + "applications/customer_index_app.jsp";
	String CUSTOMER_APPLICATION_CREATE_PAGE = CUSTOMER_URL + "applications/customer_create_app.jsp";
	String CUSTOMER_APPLICATION_APPROVE_PAGE = CUSTOMER_URL + "applications/customer_approve_app.jsp";
	String CUSTOMER_APPLICATION_FINISH_PAGE = CUSTOMER_URL + "applications/customer_finish_app.jsp";
	
	String CUSTOMER_MESSAGE_PAGE = CUSTOMER_URL + "messages/index.jsp";
	
	String CUSTOMER_PROFILE_COMMAND = "/app/customer/profile";
	String CUSTOMER_APPLICATION_INDEX_COMMAND = "/app/customer/applications";
	String CUSTOMER_APPLICATION_EDIT_COMMAND = "/app/customer/applications/edit";
	String REDIRECT_CUSTOMER_PROFILE_COMMAND = REDIRECT + CUSTOMER_PROFILE_COMMAND;
	
	/* commands path */
	String CUSTOMER_PROFILE_PATH = "customer/profile";
	String CUSTOMER_ROFILE_EDIT_PATH = CUSTOMER_PROFILE_PATH + "/editprofile";
	String CUSTOMER_PROFILE_CHANGEPASSWORD_PATH = CUSTOMER_PROFILE_PATH + "/changepassword";
	
//	String CUSTOMER_MESSAGE_PATH = "customer/message";
	
	String CUSTOMER_APPLICATIONS_PATH = "customer/applications";
	String CUSTOMER_APPLICATIONS_CREATE_PATH = CUSTOMER_APPLICATIONS_PATH + "/create";
	String CUSTOMER_APPLICATIONS_ALL_PATH = CUSTOMER_APPLICATIONS_PATH + "/all";
	String CUSTOMER_APPLICATIONS_ONE_PATH = CUSTOMER_APPLICATIONS_PATH + "/one";
	String CUSTOMER_APPLICATIONS_EDIT_PATH = CUSTOMER_APPLICATIONS_PATH + "/edit";
	String CUSTOMER_APPLICATIONS_CURRENT_PATH = CUSTOMER_APPLICATIONS_PATH + "/done";
	String CUSTOMER_APPLICATIONS_ACTIVE_PATH =	CUSTOMER_APPLICATIONS_PATH + "/active";
	String CUSTOMER_APPLICATIONS_NONACTIVE_PATH = CUSTOMER_APPLICATIONS_PATH + "/nonactive";
	String CUSTOMER_APPLICATIONS_RECEIVED_PATH = CUSTOMER_APPLICATIONS_PATH + "/received";
	String CUSTOMER_APPLICATIONS_APPROVE_PATH = CUSTOMER_APPLICATIONS_PATH + "/approve";
	String CUSTOMER_APPLICATIONS_DONE_PATH = CUSTOMER_APPLICATIONS_PATH + "/done";
	String CUSTOMER_APPLICATIONS_FINISH_PATH = CUSTOMER_APPLICATIONS_PATH + "/finishapp";
	
	String CUSTOMER = "customer";
	
	
	/* 
	 * manager 
	 */
	String MANAGER_URL = "/WEB-INF/roles/manager/";
	
	String MANAGER_PROFILE_PAGE = COMMON_URL + "profile/profile.jsp";
	String MANAGER_EDITPROFILE_PAGE = COMMON_URL + "profile/editprofile.jsp";	
//	String MANAGER_CHANGEPASSWORD_PAGE = MANAGER_URL + "profile/changepassword.jsp";
	
	String MANAGER_APPLICATION_INDEX_PAGE = MANAGER_URL + "applications/index.jsp";
	String MANAGER_APPLICATION_CREATE_PAGE = MANAGER_URL + "applications/create.jsp";
	String MANAGER_APPLICATION_SHOW_PAGE = MANAGER_URL + "applications/show.jsp";
	String MANAGER_APPLICATION_ONE_PAGE = MANAGER_URL + "applications/one.jsp";
	String MANAGER_APPLICATION_NEW_PAGE = MANAGER_URL + "applications/new.jsp";
	String MANAGER_APPLICATION_DONE_PAGE = MANAGER_URL + "applications/done.jsp";
	String MANAGER_APPLICATION_APPROVE_PAGE = MANAGER_URL + "applications/approve.jsp";
	String MANAGER_APPLICATION_FINISH_PAGE = MANAGER_URL + "applications/finishapp.jsp";
	
	String MANAGER_MESSAGE_PAGE = MANAGER_URL + "messages/index.jsp";
	
	String MANAGER_PROFILE_COMMAND = "/app/manager/profile";
	String MANAGER_APPLICATION_ALL_COMMAND = "/app/manager/applications/all";
	String MANAGER_APPLICATION_NEW_COMMAND = "/app/manager/applications/new";
	String MANAGER_APPLICATION_APPROVE_COMMAND = "/app/manager/applications/approve";
	String MANAGER_APPLICATION_INDEX_COMMAND = "/app/manager/applications";
	String MANAGER_APPLICATION_EDIT_COMMAND = "/app/manager/applications/edit";
	String MANAGER_APPLICATION_ONE_COMMAND = "/app/manager/applications/one";
	
	String REDIRECT_MANAGER_PROFILE_COMMAND = REDIRECT + MANAGER_PROFILE_COMMAND;
	
	/* commands path */
	String MANAGER_PROFILE_PATH = "manager/profile";
	String MANAGER_ROFILE_EDIT_PATH = MANAGER_PROFILE_PATH + "/editprofile";
	String MANAGER_PROFILE_CHANGEPASSWORD_PATH = MANAGER_PROFILE_PATH + "/changepassword";
	
//	String MANAGER_MESSAGE_PATH = "manager/message";
	
	String MANAGER_APPLICATIONS_PATH = "manager/applications";
	String MANAGER_APPLICATIONS_CREATE_PATH = MANAGER_APPLICATIONS_PATH + "/create";
	String MANAGER_APPLICATIONS_ALL_PATH = MANAGER_APPLICATIONS_PATH + "/all";
	String MANAGER_APPLICATIONS_ONE_PATH = MANAGER_APPLICATIONS_PATH + "/one";
	String MANAGER_APPLICATIONS_EDIT_PATH = MANAGER_APPLICATIONS_PATH + "/edit";
	String MANAGER_APPLICATIONS_CURRENT_PATH = MANAGER_APPLICATIONS_PATH + "/done";
	String MANAGER_APPLICATIONS_ACTIVE_PATH =	MANAGER_APPLICATIONS_PATH + "/active";
	String MANAGER_APPLICATIONS_NONACTIVE_PATH = MANAGER_APPLICATIONS_PATH + "/nonactive";
	String MANAGER_APPLICATIONS_NEW_PATH = MANAGER_APPLICATIONS_PATH + "/new";
	String MANAGER_APPLICATIONS_APPROVE_PATH = MANAGER_APPLICATIONS_PATH + "/approve";
	String MANAGER_APPLICATIONS_DONE_PATH = MANAGER_APPLICATIONS_PATH + "/done";
	String MANAGER_APPLICATIONS_FINISH_PATH = MANAGER_APPLICATIONS_PATH + "/finishapp";
	String MANAGER_APPLICATIONS_SEARCH_BY_ID_PATH = MANAGER_APPLICATIONS_PATH + "/findbyid";
	
	//String MANAGER_URL = "/WEB-INF/roles/manager/";
	
	String MANAGER_CREATE_USER_PAGE = MANAGER_URL + "users/create.jsp";
	String MANAGER_EDIT_USER_PAGE = MANAGER_URL + "users/edit.jsp";
	String MANAGER_USERS_INDEX_PAGE = MANAGER_URL + "users/index.jsp";
	String MANAGER_USERS_SHOW_PAGE = MANAGER_URL + "users/show.jsp";
	
	String MANAGER_USERS_PATH = "manager/users";
	
	String MANAGER_CREATE_USER_PATH = MANAGER_USERS_PATH + "/create";
	String MANAGER_USER_EDIT_PATH = MANAGER_USERS_PATH + "/edit";
	String MANAGER_USER_DELETE_PATH = MANAGER_USERS_PATH + "/delete";
	String MANAGER_USERS_SHOW_PATH = MANAGER_USERS_PATH + "/show";
	
	String MANAGER = "manager";

	
	/* 
	 * workman 
	 */
	String WORKMAN_URL = "/WEB-INF/roles/workman/";
	
	String WORKMAN_PROFILE_PAGE = COMMON_URL + "profile/profile.jsp";
	String WORKMAN_EDITPROFILE_PAGE = COMMON_URL + "profile/editprofile.jsp";	
//	String WORKMAN_CHANGEPASSWORD_PAGE = WORKMAN_URL + "profile/changepassword.jsp";
	
	String WORKMAN_APPLICATION_INDEX_PAGE = WORKMAN_URL + "applications/index.jsp";
	String WORKMAN_APPLICATION_CREATE_PAGE = WORKMAN_URL + "applications/create.jsp";
	String WORKMAN_APPLICATION_SHOW_PAGE = WORKMAN_URL + "applications/show.jsp";
	String WORKMAN_APPLICATION_ONE_PAGE = WORKMAN_URL + "applications/one.jsp";
	String WORKMAN_APPLICATION_NEW_PAGE = WORKMAN_URL + "applications/new.jsp";
	String WORKMAN_APPLICATION_DONE_PAGE = WORKMAN_URL + "applications/done.jsp";
	String WORKMAN_APPLICATION_APPROVE_PAGE = WORKMAN_URL + "applications/approve.jsp";
	String WORKMAN_APPLICATION_FINISH_PAGE = WORKMAN_URL + "applications/finishapp.jsp";
	
	String WORKMAN_MESSAGE_PAGE = WORKMAN_URL + "messages/index.jsp";
	
	String WORKMAN_PROFILE_COMMAND = "/app/workman/profile";
	String WORKMAN_APPLICATION_INDEX_COMMAND = "/app/workman/applications";
	String WORKMAN_APPLICATION_EDIT_COMMAND = "/app/workman/applications/edit";
	String REDIRECT_WORKMAN_PROFILE_COMMAND = REDIRECT + WORKMAN_PROFILE_COMMAND;
	
	/* commands path */
	String WORKMAN_PROFILE_PATH = "workman/profile";
	String WORKMAN_ROFILE_EDIT_PATH = WORKMAN_PROFILE_PATH + "/editprofile";
	String WORKMAN_PROFILE_CHANGEPASSWORD_PATH = WORKMAN_PROFILE_PATH + "/changepassword";
	
	String WORKMAN_MESSAGE_PATH = "workman/message";
	
	String WORKMAN_APPLICATIONS_PATH = "workman/applications";
	String WORKMAN_APPLICATIONS_CREATE_PATH = WORKMAN_APPLICATIONS_PATH + "/create";
	String WORKMAN_APPLICATIONS_ALL_PATH = WORKMAN_APPLICATIONS_PATH + "/all";
	String WORKMAN_APPLICATIONS_ONE_PATH = WORKMAN_APPLICATIONS_PATH + "/one";
	String WORKMAN_APPLICATIONS_EDIT_PATH = WORKMAN_APPLICATIONS_PATH + "/edit";
	String WORKMAN_APPLICATIONS_CURRENT_PATH = WORKMAN_APPLICATIONS_PATH + "/done";
	String WORKMAN_APPLICATIONS_ACTIVE_PATH =	WORKMAN_APPLICATIONS_PATH + "/active";
	String WORKMAN_APPLICATIONS_NONACTIVE_PATH = WORKMAN_APPLICATIONS_PATH + "/nonactive";
	String WORKMAN_APPLICATIONS_NEW_PATH = WORKMAN_APPLICATIONS_PATH + "/new";
	String WORKMAN_APPLICATIONS_APPROVE_PATH = WORKMAN_APPLICATIONS_PATH + "/approve";
	String WORKMAN_APPLICATIONS_DONE_PATH = WORKMAN_APPLICATIONS_PATH + "/done";
	String WORKMAN_APPLICATIONS_FINISH_PATH = WORKMAN_APPLICATIONS_PATH + "/finishapp";
	
	String WORKMAN = "workman";
	
	
	/*
	 * WEB FILTERS
	 */
	String FILTER_PATTERN = "/*";
	String DISABLE_CACHE_FILTER_PATTERN = "/*";
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
