package ua.training.repairagency.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.commands.common.*;
import ua.training.repairagency.controller.commands.customer.*;
import ua.training.repairagency.controller.commands.manager.*;
//TODO import ua.training.repairagency.controller.commands.workman.*;

import ua.training.repairagency.controller.constants.URL;

/**
 * Servlet implementation class AgencyServlet
 */
@WebServlet(URL.SERVLET_PATTERN)
public class AgencyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Map<String, Command> commands;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() {
		commands = new HashMap<>();
		
		commands.put(URL.LOGOUT, new LogoutCommand());
		commands.put(URL.LOGIN, new LoginCommand());
		commands.put(URL.REGISTRATION, new RegistrationCommand());
		commands.put(URL.ERROR_404, new Error404Command());
		commands.put(URL.INDEX, new IndexPageCommand());
		
		commands.put(URL.MANAGER_PAGE_PATH, new ManagerPageCommand());
		commands.put(URL.MANAGER_MESSAGE_PATH, new ManagerMessageCommand());
		commands.put(URL.MANAGER_WORKMEN_PATH, new ManagerGetAllWorkmenCommand());
		commands.put(URL.MANAGER_APPLICATIONS_PATH, new ManagerGetAllAppsCommand());
		
		commands.put(URL.CUSTOMER_PAGE_PATH, new IndexPageCommand());
		commands.put(URL.CUSTOMER_MESSAGE_PATH, new CustomerMessageCommand());
		commands.put(URL.CUSTOMER_WORKMEN_PATH, new CustomerGetAllWorkmenCommand());
		commands.put(URL.CUSTOMER_APPLICATIONS_PATH, new CustomerGetAllAppsCommand());
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
													throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ServletException | IOException e) {
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
														throws IOException, ServletException {		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath() + URL.CONTEXT_ADDON;		
		String commandName = requestURI.replaceAll(contextPath, URL.EMPTY);

		String path = commands.getOrDefault
				(commandName, (r)->commands.get(URL.ERROR_404).execute(request)).execute(request);
		
		if (path.contains(URL.REDIRECT)) {
			response.sendRedirect(request.getContextPath() + path.replace(URL.REDIRECT, URL.EMPTY));
		} else {
			request.getRequestDispatcher(path).forward(request, response);
		}		
	}
	
}
