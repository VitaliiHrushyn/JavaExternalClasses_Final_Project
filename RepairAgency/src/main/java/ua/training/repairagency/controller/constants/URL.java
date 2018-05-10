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
	
	
	
	/* manager */
	String MANAGER_PROFILE = "/WEB-INF/roles/manager/index.jsp";
	String REDIRECT_MANAGER_PROFILE_COMMAND = "redirect:/app/manager/profile";
	String MANAGER_PROFILE_COMMAND = "/app/manager/profile";
	/* manager */
	String MANAGER_PAGE_PATH = "manager/profile";
	String MANAGER_MESSAGE_PATH = "manager/message";
	String MANAGER_WORKMEN_PATH = "manager/workmen";
	String MANAGER_APPLICATIONS_PATH = "manager/applications";
	String MANAGER = "manager";
	
	
	
	/* 
	 * customer 
	 */
	String ROLE_PAGE = "/WEB-INF/roles/";
	
	String CUSTOMER_PAGE = "/WEB-INF/roles/customer/";
	
	String CUSTOMER_PROFILE_PAGE = CUSTOMER_PAGE + "profile/profile.jsp";
	String CUSTOMER_EDITPROFILE_PAGE = CUSTOMER_PAGE + "profile/editprofile.jsp";	
	String CUSTOMER_CHANGEPASSWORD_PAGE = CUSTOMER_PAGE + "profile/changepassword.jsp";
	
	String CUSTOMER_APPLICATION_INDEX_PAGE = CUSTOMER_PAGE + "applications/index.jsp";
	String CUSTOMER_APPLICATION_CREATE_PAGE = CUSTOMER_PAGE + "applications/create.jsp";
	String CUSTOMER_APPLICATION_SHOW_PAGE = CUSTOMER_PAGE + "applications/show.jsp";
	String CUSTOMER_APPLICATION_ONE_PAGE = CUSTOMER_PAGE + "applications/one.jsp";
	String CUSTOMER_APPLICATION_RECEIVED_PAGE = CUSTOMER_PAGE + "applications/received.jsp";
	String CUSTOMER_APPLICATION_APPROVE_PAGE = CUSTOMER_PAGE + "applications/approve.jsp";
	
	String CUSTOMER_MESSAGE_PAGE = CUSTOMER_PAGE + "messages/index.jsp";
	
	String CUSTOMER_PROFILE_COMMAND = "/app/customer/profile";
	String CUSTOMER_APPLICATION_ALL_COMMAND = "/app/customer/applications/show";
	String CUSTOMER_APPLICATION_EDIT_COMMAND = "/app/customer/applications/edit";
	String CUSTOMER_APPLICATION_RECEIVED_COMMAND = "/app/customer/applications/received";
	String REDIRECT_CUSTOMER_PROFILE_COMMAND = REDIRECT + CUSTOMER_PROFILE_COMMAND;
	
	/* commands path */
	String CUSTOMER_PROFILE_PATH = "customer/profile";
//	String CUSTOMER_LOGIN_PATH = "customer/login";
	String CUSTOMER_ROFILE_EDIT_PATH = CUSTOMER_PROFILE_PATH + "/editprofile";
	String CUSTOMER_PROFILE_CHANGEPASSWORD_PATH = CUSTOMER_PROFILE_PATH + "/changepassword";
	
	String CUSTOMER_MESSAGE_PATH = "customer/message";
	
	String CUSTOMER_APPLICATIONS = "customer/applications";
	String CUSTOMER_APPLICATIONS_CREATE_PATH = CUSTOMER_APPLICATIONS + "/create";
	String CUSTOMER_APPLICATIONS_ALL_PATH = CUSTOMER_APPLICATIONS + "/show";
	String CUSTOMER_APPLICATIONS_ONE_PATH = CUSTOMER_APPLICATIONS + "/one";
	String CUSTOMER_APPLICATIONS_EDIT_PATH = CUSTOMER_APPLICATIONS + "/edit";
	String CUSTOMER_APPLICATIONS_CURRENT_PATH = CUSTOMER_APPLICATIONS + "/done";
	String CUSTOMER_APPLICATIONS_ACTIVE_PATH =	CUSTOMER_APPLICATIONS + "/active";
	String CUSTOMER_APPLICATIONS_NONACTIVE_PATH = CUSTOMER_APPLICATIONS + "/nonactive";
	String CUSTOMER_APPLICATIONS_RECEIVED_PATH = CUSTOMER_APPLICATIONS + "/received";
	String CUSTOMER_APPLICATIONS_APPROVE_PATH = CUSTOMER_APPLICATIONS + "/approve";
	
	String CUSTOMER_TESTIMONIALS_PATH = "customer/testimonials";
	String CUSTOMER_TESTIMONIALS_EDIT_PATH = CUSTOMER_TESTIMONIALS_PATH + "/edit";
	
	String CUSTOMER = "customer";
	
	
	/* 
	 * workman 
	 */
	String WORKMAN_PAGE = "/WEB-INF/workman/profile.jsp";	
	String REDIRECT_WORKMAN_PROFILE_COMMAND = "redirect:/app/workman/profile";
	String WORKMAN_PROFILE_COMMAND = "/app/workman/profile";
	/* workman */
	//TODO
	String WORKMAN = "workman";
	
	
	
	/*
	 * WEB FILTERS
	 */
	String FILTER_PATTERN = "/*";
	String DISABLE_CACHE_FILTER_PATTERN = "/*";
	
	
	
	
	
	
}
