package ua.training.repairagency.controller.constants;

public interface PathConstants {
	
	/*
	 * SERVLET constants
	 */
	String CONTEXT_PATH_ADDON = "/app/";
	String EXCEPTION_PATH = "exception";
	String LOGOUT_PATH = "logout";
	String LOGIN_PATH = "login";
	String REGISTRATION_PATH = "registration";
	String ERROR_404_PATH = "404";
	
	String MANAGER_PAGE_PATH = "manager/page";
	String MANAGER_MESSAGE_PATH = "manager/message";
	String MANAGER_WORKMEN_PATH = "manager/workmen";
	String MANAGER_APPLICATIONS_PATH = "manager/applications";
	
	String CUSTOMER_PAGE_PATH = "customer/page";
	String CUSTOMER_MESSAGE_PATH = "customer/message";
	String CUSTOMER_WORKMEN_PATH = "customer/workmen";
	String CUSTOMER_APPLICATIONS_PATH = "customer/applications";
	
	/*
	 * COMMON path constants
	 */
	String PAGE_404 = "/WEB-INF/404.jsp";
	String LOGIN_PAGE = "/WEB-INF/default/login.jsp";
	String REDIRECT_LOGIN_COMMAND = "redirect:/app/login";
	String LOGIN_COMMAND = "/app/login";
	String LOGOUT_COMMAND = "/app/logout";
	String REGISTRATION_COMMAND = "/app/registration";
	
	/*
	 * MANAGER path constants
	 */
	String MANAGER_PAGE = "/WEB-INF/manager/index.jsp";
	String REDIRECT_MANAGER_PAGE = "redirect:/app/manager/page";
	String MANAGER_PAGE_COMMAND = "/app/manager/page";
	
	/*
	 * CUSTOMER path constants
	 */
	String CUSTOMER_PAGE = "/WEB-INF/customer/index.jsp";	
	String REDIRECT_CUSTOMER_PAGE = "redirect:/app/customer/page";
	String CUSTOMER_PAGE_COMMAND = "/app/customer/page";
	
	/*
	 * WORKMAN path constants
	 */
	String WORKMAN_PAGE = "/WEB-INF/workman/index.jsp";	
	String REDIRECT_WORKMAN_PAGE = "redirect:/app/workman/page";
	String WORKMAN_PAGE_COMMAND = "/app/workman/page";
	
}
