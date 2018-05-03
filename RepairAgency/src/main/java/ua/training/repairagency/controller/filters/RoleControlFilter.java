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
        String error404commandURI = request.getContextPath() + URL.ERROR_404_COMMAND;

        boolean isLogoutCommand = request.getRequestURI().equals(logoutCommandURI);
        boolean isError404Command = request.getRequestURI().equals(error404commandURI);
        
        boolean isURIvalid = (validateRoleURI(request) || isLogoutCommand || isError404Command);

        if (isURIvalid) {
        	chain.doFilter(request, response);        	
        } else {   
        	response.sendRedirect(error404commandURI);
        } 
    }	

	private boolean validateRoleURI(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute(USER);
		if (user != null) {
			return request.getRequestURI().contains(user.getRole().toString().toLowerCase());
		}
		return true;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}	

}
