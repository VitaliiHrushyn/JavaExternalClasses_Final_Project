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
	String MANAGER_PAGE = "/WEB-INF/roles/manager/index.jsp";
	String REDIRECT_MANAGER_PAGE = "redirect:/app/manager/page";
	String MANAGER_PAGE_COMMAND = "/app/manager/page";
	/* manager */
	String MANAGER_PAGE_PATH = "manager/page";
	String MANAGER_MESSAGE_PATH = "manager/message";
	String MANAGER_WORKMEN_PATH = "manager/workmen";
	String MANAGER_APPLICATIONS_PATH = "manager/applications";
	String MANAGER = "manager";
	
	
	
	/* 
	 * customer 
	 */
	String CUSTOMER_URL = "/WEB-INF/roles/customer/";
	
	String CUSTOMER_PROFILE_PAGE = CUSTOMER_URL + "profile/profile.jsp";
	String CUSTOMER_EDITPROFILE_PAGE = CUSTOMER_URL + "profile/editprofile.jsp";	
	String CUSTOMER_CHANGEPASSWORD_PAGE = CUSTOMER_URL + "profile/changepassword.jsp";
	
	String CUSTOMER_APPLICATION_INDEX_PAGE = CUSTOMER_URL + "applications/index.jsp";
	String CUSTOMER_APPLICATION_CREATE_PAGE = CUSTOMER_URL + "applications/create.jsp";
	String CUSTOMER_APPLICATION_ALL_PAGE = CUSTOMER_URL + "applications/all.jsp";
	
	String CUSTOMER_MESSAGE_PAGE = CUSTOMER_URL + "messages/index.jsp";
	
	String CUSTOMER_PROFILE_COMMAND = "/app/customer/profile";
	String REDIRECT_CUSTOMER_INDEX_COMMAND = REDIRECT + CUSTOMER_PROFILE_COMMAND;
	
	/* commands path */
	String CUSTOMER_PROFILE_PATH = "customer/profile";
	String CUSTOMER_ROFILE_EDIT_PATH = CUSTOMER_PROFILE_PATH + "/editprofile";
	String CUSTOMER_PROFILE_CHANGEPASSWORD_PATH = CUSTOMER_PROFILE_PATH + "/changepassword";
	
	String CUSTOMER_MESSAGE_PATH = "customer/message";
	
	String CUSTOMER_APPLICATIONS_PATH = "customer/applications";
	String CUSTOMER_APPLICATIONS_CREATE_PATH = CUSTOMER_APPLICATIONS_PATH + "/create";
	String CUSTOMER_APPLICATIONS_ALL_PATH = CUSTOMER_APPLICATIONS_PATH + "/all";
	String CUSTOMER_APPLICATIONS_CURRENT_PATH = CUSTOMER_APPLICATIONS_PATH + "/current";
	String CUSTOMER_APPLICATIONS_ACTIVE_PATH =	CUSTOMER_APPLICATIONS_PATH + "/active";
	String CUSTOMER_APPLICATIONS_NONACTIVE_PATH = CUSTOMER_APPLICATIONS_PATH + "/nonactive";
	
	String CUSTOMER = "customer";
	
	
	/* 
	 * workman 
	 */
	String WORKMAN_PAGE = "/WEB-INF/workman/index.jsp";	
	String REDIRECT_WORKMAN_PAGE = "redirect:/app/workman/page";
	String WORKMAN_PAGE_COMMAND = "/app/workman/page";
	/* workman */
	//TODO
	String WORKMAN = "workman";
	
	
	
	/*
	 * WEB FILTERS
	 */
	String FILTER_PATTERN = "/*";
	String DISABLE_CACHE_FILTER_PATTERN = "/*";
	
}
