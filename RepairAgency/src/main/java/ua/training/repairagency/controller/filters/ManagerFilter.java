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

import ua.training.repairagency.model.entities.user.User;
import ua.training.repairagency.model.entities.user.UserRole;

@WebFilter(urlPatterns="/*")
public class ManagerFilter implements Filter {

	@Override
	public void destroy() {}

	@Override
	 public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
			 											throws ServletException, IOException {    
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        
        String loginCommandURI = request.getContextPath() + LOGIN_COMMAND;
        String logoutCommandURI = request.getContextPath() + LOGOUT_COMMAND;
        String registrationCommandURI = request.getContextPath() + REGISTRATION_COMMAND;
        String managerPageCommandURI = request.getContextPath() + MANAGER_PAGE_COMMAND;        

        UserRole role = UserRole.UNKNOWN;
        if (session.getAttribute("user") != null) {
        	role = ((User) session.getAttribute("user")).getRole();
        }

        boolean isManager = role.equals(UserRole.MANAGER);
        boolean isLoginCommand = request.getRequestURI().equals(loginCommandURI);
        boolean isRegistrationCommand = request.getRequestURI().equals(registrationCommandURI);
        boolean isURIcontainsProperlyPath = request.getRequestURI().contains("manager");
        boolean isLogoutCommand = request.getRequestURI().equals(logoutCommandURI);

        if (isManager && (	isLoginCommand || 
        					isRegistrationCommand ||
        					(!isURIcontainsProperlyPath && !isLogoutCommand)
        				 )
        	) {
        	response.sendRedirect(managerPageCommandURI);
        } else {            
            chain.doFilter(request, response);
        }
    }		

	@Override
	public void init(FilterConfig arg0) throws ServletException {}	

}
