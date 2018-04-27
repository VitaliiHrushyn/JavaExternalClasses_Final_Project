package ua.training.repairagency.controller.filters.authentication;

import static ua.training.repairagency.controller.constants.PathConstants.*;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.entities.user.UserRole;

public abstract class AbstractRoleFilter implements Filter {
	
	protected UserRole role;
	protected HttpServletRequest request;

	@Override
	public void destroy() {}

	@Override
	 public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
			 											throws ServletException, IOException {    
        request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        
        String loginCommandURI = request.getContextPath() + LOGIN_COMMAND;
        String logoutCommandURI = request.getContextPath() + LOGOUT_COMMAND;
        String registrationCommandURI = request.getContextPath() + REGISTRATION_COMMAND;
        String rolePageCommandURI = getCommandPageURI();        

        role = UserRole.UNKNOWN;
        if (session.getAttribute("user") != null) {
        	role = ((User) session.getAttribute("user")).getRole();
        }

        boolean isValidRole = validateRole();
        boolean isLoginCommand = request.getRequestURI().equals(loginCommandURI);
        boolean isRegistrationCommand = request.getRequestURI().equals(registrationCommandURI);
        boolean isURIcontainsProperlyPath = validateURI();
        boolean isLogoutCommand = request.getRequestURI().equals(logoutCommandURI);

        if (isValidRole && ( isLoginCommand || 
        					 isRegistrationCommand ||
        					 (!isURIcontainsProperlyPath && !isLogoutCommand)
        				   )
        	) {
        	response.sendRedirect(rolePageCommandURI);
        } else {            
            chain.doFilter(request, response);
        }
    }		

	abstract String getCommandPageURI();

	abstract boolean validateURI();

	abstract boolean validateRole();

	@Override
	public void init(FilterConfig arg0) throws ServletException {}	

}
