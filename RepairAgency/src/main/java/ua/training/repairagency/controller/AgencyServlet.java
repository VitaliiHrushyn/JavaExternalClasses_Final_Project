package ua.training.repairagency.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.training.repairagency.controller.commands.*;
import ua.training.repairagency.controller.commands.common.*;
import ua.training.repairagency.controller.commands.customer.*;
import ua.training.repairagency.controller.commands.manager.*;
//TODO import ua.training.repairagency.controller.commands.workman.*;

import static ua.training.repairagency.controller.constants.PathConstants.*;

/**
 * Servlet implementation class AgencyServlet
 */
@WebServlet("/app/*")
public class AgencyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Map<String, Command> commands;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() {
		commands = new HashMap<>();
		
		commands.put(EXCEPTION_PATH, new ExceptionCommand());
		commands.put(LOGOUT_PATH, new LogoutCommand());
		commands.put(LOGIN_PATH, new LoginCommand());
		commands.put(REGISTRATION_PATH, new RegistrationCommand());
		commands.put(ERROR_404_PATH, new Error404Command());
		
		commands.put(MANAGER_PAGE_PATH, new ManagerPageCommand());
		commands.put(MANAGER_MESSAGE_PATH, new ManagerMessageCommand());
		commands.put(MANAGER_WORKMEN_PATH, new ManagerGetAllWorkmenCommand());
		commands.put(MANAGER_APPLICATIONS_PATH, new ManagerGetAllAppsCommand());
		
		commands.put(CUSTOMER_PAGE_PATH, new CustomerPageCommand());
		commands.put(CUSTOMER_MESSAGE_PATH, new CustomerMessageCommand());
		commands.put(CUSTOMER_WORKMEN_PATH, new CustomerGetAllWorkmenCommand());
		commands.put(CUSTOMER_APPLICATIONS_PATH, new CustomerGetAllAppsCommand());
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
													throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
													throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ClassNotFoundException, 
				InstantiationException, IllegalAccessException, SQLException {
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath() + CONTEXT_PATH_ADDON;		
		String commandName = requestURI.replaceAll(contextPath, "");

		String path = commands.getOrDefault
				(commandName, (r)->commands.get("404").execute(request)).execute(request);
		
		if (path.contains("redirect:")) {
			response.sendRedirect(request.getContextPath() + path.replace("redirect:", ""));
		} else {
			request.getRequestDispatcher(path).forward(request, response);
		}		
	}
	
}
