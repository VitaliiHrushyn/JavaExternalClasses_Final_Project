package ua.training.repairagency.controller.commands.common;

import ua.training.repairagency.controller.constants.URL;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.commands.AbstractCommand;
import ua.training.repairagency.controller.commands.Command;

public class Error404Command extends AbstractCommand {

	private static String path = URL.ERROR_404;

	public Error404Command(Map<String, Command> commands) {
		super(path , commands);
	}

	@Override
	public String execute(HttpServletRequest request) {
		return URL.PAGE_404;
	}

}
