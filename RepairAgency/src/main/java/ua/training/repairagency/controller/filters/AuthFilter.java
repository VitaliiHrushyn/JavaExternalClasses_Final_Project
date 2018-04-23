package ua.training.repairagency.controller.filters;

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

import static ua.training.repairagency.controller.PathConstants.*;

@WebFilter(urlPatterns="/*")
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
        
System.out.println("filter session user: "+session.getAttribute("user"));

        boolean loggedIn = session != null && session.getAttribute("user") != null;
        boolean loginRequest = request.getRequestURI().equals(loginPageURI);
        boolean loginCommand = request.getRequestURI().equals(loginCommandURI);

        if (loggedIn || loginRequest || loginCommand) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect(loginPageURI);
        }
    }		
	

	@Override
	public void init(FilterConfig arg0) throws ServletException {}	

}
