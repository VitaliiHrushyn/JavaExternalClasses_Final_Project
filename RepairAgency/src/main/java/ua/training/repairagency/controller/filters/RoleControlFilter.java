package ua.training.repairagency.controller.filters;

import static ua.training.repairagency.controller.constants.AttributeOrParam.USER;

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

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.model.entities.user.User;

@WebFilter(urlPatterns=URL.FILTER_PATTERN)
public class RoleControlFilter implements Filter {

	@Override
	public void destroy() {}

	@Override
	 public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
			 											throws ServletException, IOException {    
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String logoutCommandURI = request.getContextPath() + URL.LOGOUT_COMMAND;

        boolean isLogoutCommand = request.getRequestURI().equals(logoutCommandURI);        
        boolean isURIvalid = (checkUserAndURI(request) || isLogoutCommand);

        if (isURIvalid) {
        	chain.doFilter(request, response);        	
        } else {   
        	response.sendRedirect(logoutCommandURI);
        } 
    }	

	private boolean checkUserAndURI(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute(USER);
		/* 
		 * This filter doesn't act on unlogged users 
		 */
		if (user == null) {
			return true; 
		} else {
			return request.getRequestURI().contains(user.getRole().toString().toLowerCase());
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}	

}
