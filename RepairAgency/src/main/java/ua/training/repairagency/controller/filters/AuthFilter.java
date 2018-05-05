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
import javax.servlet.http.HttpSession;

import ua.training.repairagency.controller.constants.URL;

@WebFilter(urlPatterns=URL.FILTER_PATTERN)
public class AuthFilter implements Filter {

	@Override
	public void destroy() {}

	@Override
	 public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
			 											throws ServletException, IOException {    
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        
        String indexCommandURI = request.getContextPath() + URL.INDEX_COMMAND;
        String loginCommandURI = request.getContextPath() + URL.LOGIN_COMMAND;
        String registrationCommandURI = request.getContextPath() + URL.REGISTRATION_COMMAND;        

        boolean isLoggedIn = (session != null) && (session.getAttribute(USER) != null);
        boolean isIndexCommand = request.getRequestURI().equals(indexCommandURI);
        boolean isLoginCommand = request.getRequestURI().equals(loginCommandURI);
        boolean isRegistrationCommand = request.getRequestURI().equals(registrationCommandURI);

        if (isLoggedIn || isLoginCommand || isRegistrationCommand || isIndexCommand) {
        	chain.doFilter(request, response);
        } else {
            response.sendRedirect(indexCommandURI);
        }
    }		

	@Override
	public void init(FilterConfig arg0) throws ServletException {}	

}
