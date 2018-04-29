package ua.training.repairagency.controller.constants;

public interface PathConstants {
	
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
	String CUSTOMER_WORKMAN_COMMAND = "/app/workman/page";
	
}
