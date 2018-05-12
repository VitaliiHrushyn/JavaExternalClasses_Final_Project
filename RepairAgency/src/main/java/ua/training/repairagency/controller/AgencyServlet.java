package ua.training.repairagency.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.training.repairagency.controller.commands.Command;
import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.utils.CommandsCreator;

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
		commands = CommandsCreator.create(commands);		
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
