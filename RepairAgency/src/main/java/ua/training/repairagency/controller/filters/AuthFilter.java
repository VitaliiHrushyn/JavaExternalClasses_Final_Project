package ua.training.repairagency.controller.filters;

import static ua.training.repairagency.controller.constants.PathConstants.*;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter(urlPatterns="/*")
public class AuthFilter implements Filter {

	@Override
	public void destroy() {}

	@Override
	 public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {    
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        String loginPageURI = request.getContextPath() + LOGIN_PAGE;
        String loginCommandURI = request.getContextPath() + LOGIN_COMMAND;
        String registrationCommandURI = request.getContextPath() + REGISTRATION_COMMAND;
        String alreadyloggedinURI = request.getContextPath() + ALREDY_LOGIN_PAGE;
        
//System.out.println("filter session user: "+session.getAttribute("user"));

        boolean loggedIn = session != null && session.getAttribute("user") != null;
        boolean loginRequest = request.getRequestURI().equals(loginPageURI);
        boolean loginCommand = request.getRequestURI().equals(loginCommandURI);
        boolean registrationCommand = request.getRequestURI().equals(registrationCommandURI);

        if (loggedIn && loginRequest) {
        	response.sendRedirect(alreadyloggedinURI);
        }
        
        if (loggedIn || loginRequest || loginCommand || registrationCommand) {
System.out.println("filter PASS");
        	chain.doFilter(request, response);
        } else {
System.out.println("filter BLOCK");
            response.sendRedirect(loginPageURI);
        }
    }		
	

	@Override
	public void init(FilterConfig arg0) throws ServletException {}	

}
