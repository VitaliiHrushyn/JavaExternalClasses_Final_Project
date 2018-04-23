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
		commands.put("message", new MessageCommand());
		commands.put("logout", new LogoutCommand());
		commands.put("login", new LoginCommand());
		commands.put("404", new Error404Command());
		commands.put("index", new IndexCommand());
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
		String[] URIArr = request.getRequestURI().split("/");
		String commandName = URIArr[URIArr.length - 1];
		String path = commands.getOrDefault
				(commandName, (r)->commands.get("404").execute(request)).execute(request);
		
		if (path.contains("redirect:")) {
			response.sendRedirect(request.getContextPath() + path.replace("redirect:", ""));
			
		} else {
			request.getRequestDispatcher(path).forward(request, response);
		}
		
	}
}
