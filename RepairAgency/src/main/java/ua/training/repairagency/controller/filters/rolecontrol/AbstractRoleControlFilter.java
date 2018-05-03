package ua.training.repairagency.controller.filters.rolecontrol;

import static ua.training.repairagency.controller.constants.AttributeOrParam.USER;

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

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.entities.user.UserRole;

public abstract class AbstractRoleControlFilter implements Filter {
	
	protected UserRole role;
	protected HttpServletRequest request;

	@Override
	public void destroy() {}

	@Override
	 public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
			 											throws ServletException, IOException {    
        request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession();
        role = getRoleFrom(session);
        
        String loginCommandURI = request.getContextPath() + URL.LOGIN_COMMAND;
        String logoutCommandURI = request.getContextPath() + URL.LOGOUT_COMMAND;
        String registrationCommandURI = request.getContextPath() + URL.REGISTRATION_COMMAND;
        String rolePageCommandURI = getRolePageCommandURI();       

        boolean isRoleValid = validateRole();
        
        boolean isURIcontainsProperlyRolePath = validateRoleURI();
        boolean isLoginCommand = request.getRequestURI().equals(loginCommandURI);
        boolean isRegistrationCommand = request.getRequestURI().equals(registrationCommandURI);
        boolean isLogoutCommand = request.getRequestURI().equals(logoutCommandURI);
        
        boolean isURIinvalid = isLoginCommand || isRegistrationCommand ||
        		(!isURIcontainsProperlyRolePath && !isLogoutCommand);

        if (isRoleValid && isURIinvalid) {
        	response.sendRedirect(rolePageCommandURI);
        } else {            
            chain.doFilter(request, response);
        }
    }		

	private UserRole getRoleFrom(HttpSession session) {		
        if (session.getAttribute(USER) != null) {
        	return ((User) session.getAttribute(USER)).getRole();
        } else {
        	return UserRole.UNKNOWN;
        }
	}

	abstract String getRolePageCommandURI();

	abstract boolean validateRoleURI();

	abstract boolean validateRole();

	@Override
	public void init(FilterConfig arg0) throws ServletException {}	

}
