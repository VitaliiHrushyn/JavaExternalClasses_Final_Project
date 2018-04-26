//package ua.training.repairagency.controller.filters;
//
//import static ua.training.repairagency.controller.constants.PathConstants.*;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import ua.training.repairagency.model.entities.user.User;
//import ua.training.repairagency.model.entities.user.UserRole;
//
//
//public abstract class AbstractRoleFilter implements Filter {
//	
//	protected HttpServletRequest request;
//	protected HttpServletResponse response;
//	protected HttpSession session;
//    
//	protected String loginCommandURI;
//	protected String logoutCommandURI;
//	protected String registrationCommandURI;
//
//	protected UserRole role;
//    
//	protected boolean isRoleValid;
//	protected boolean isLoginCommand;
//	protected boolean isRegistrationCommand;
//	protected boolean isURIcontainsProperlyPath;
//	protected boolean isLogoutCommand;
//	protected String commandPageURI;
//
//	@Override
//	public void destroy() {}
//
//	@Override
//	 public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
//			 											throws ServletException, IOException {    
//        request = (HttpServletRequest) req;
//        response = (HttpServletResponse) res;
//        
//        session = request.getSession(false);
//        
//        loginCommandURI = request.getContextPath() + LOGIN_COMMAND;
//        logoutCommandURI = request.getContextPath() + LOGOUT_COMMAND;
//        registrationCommandURI = request.getContextPath() + REGISTRATION_COMMAND;
//        
//        setRole();
//        
//        isRoleValid = validateRole();
//        isLoginCommand = request.getRequestURI().equals(loginCommandURI);
//        isRegistrationCommand = request.getRequestURI().equals(registrationCommandURI);
//        isURIcontainsProperlyPath = validateURI();
//        isLogoutCommand = request.getRequestURI().equals(logoutCommandURI);
//        
//        commandPageURI = getCommandPageURI();        
//
//        
//        if (isRoleValid && (isLoginCommand || 
//        					isRegistrationCommand ||
//        					(!isURIcontainsProperlyPath && !isLogoutCommand)
//        				 )
//        	) {
//        	response.sendRedirect(commandPageURI);
//        } else {            
//            chain.doFilter(request, response);
//        }
//                 
//        chain.doFilter(request, response);
//    }
//
//	protected abstract String getCommandPageURI();
//
//	protected abstract boolean validateURI();
//
//	protected abstract boolean validateRole();
//
//	private void setRole() {
//		if (session.getAttribute("user") != null) {
//        	role = ((User) session.getAttribute("user")).getRole();
//        } else {
//        	role = UserRole.UNKNOWN;
//        }
//	}		
//
//	@Override
//	public void init(FilterConfig arg0) throws ServletException {}	
//
//}
