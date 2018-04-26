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
import ua.training.repairagency.controller.commands.customer.*;
import ua.training.repairagency.controller.commands.manager.*;

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
		
		commands.put("exception", new ExceptionCommand());
		commands.put("logout", new LogoutCommand());
		commands.put("login", new LoginCommand());
		commands.put("registration", new RegistrationCommand());
		commands.put("404", new Error404Command());
		
		commands.put("manager/page", new ManagerPageCommand());
		commands.put("manager/message", new ManagerMessageCommand());
		commands.put("manager/workmen", new ManagerGetAllWorkmenCommand());
		commands.put("manager/applications", new ManagerGetAllAppsCommand());
		
		commands.put("customer/message", new CustomerMessageCommand());
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
		String contextPath = request.getContextPath() + "/app/";		
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
