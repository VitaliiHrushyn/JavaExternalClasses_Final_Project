package ua.training.repairagency.controller.constants;

public interface URL {
	
	/*
	 * SERVLET constants
	 */
		
	
	
	
	/*
	 * COMMANDS path constants
	 */
	/* common */
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
	/* common */
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
	
	
	
	/* customer */
	String CUSTOMER_URL = "/WEB-INF/roles/customer/";
	String CUSTOMER_INDEX_PAGE = CUSTOMER_URL + "index/index.jsp";	
	String CUSTOMER_APPLICATION_PAGE = CUSTOMER_URL + "applications/index.jsp";
	String CUSTOMER_MESSAGE_PAGE = CUSTOMER_URL + "messages/index.jsp";
	
	String CUSTOMER_INDEX_COMMAND = "/app/customer/index";
	String REDIRECT_CUSTOMER_INDEX_COMMAND = REDIRECT + CUSTOMER_INDEX_COMMAND;
	
	/* commands path */
	String CUSTOMER_INDEX_PATH = "customer/index";
	String CUSTOMER_MESSAGE_PATH = "customer/message";
	String CUSTOMER_EDITPROFILE_PATH = "customer/editprofile";
	String CUSTOMER_CHANGEPASSWORD_PATH = "customer/changepassword";
	String CUSTOMER_APPLICATIONS_PATH = "customer/applications";
	String CUSTOMER = "customer";
	
	/* workman */
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
