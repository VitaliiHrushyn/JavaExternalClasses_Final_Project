package ua.training.repairagency.controller.commands.common;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ua.training.repairagency.controller.constants.URL;
import ua.training.repairagency.controller.commands.AbstractCommand;
import ua.training.repairagency.controller.commands.Command;

public class IndexPageCommand extends AbstractCommand {

	private static String path = URL.INDEX;

	public IndexPageCommand(Map<String, Command> commands) {
		super(path , commands);
	}

	@Override
	public String execute(HttpServletRequest request) {
		
		return URL.INDEX_PAGE;
	}

}
