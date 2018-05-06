package ua.training.repairagency.controller.utils;

import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import ua.training.repairagency.model.entities.application.AppStatus;
import ua.training.repairagency.model.entities.application.Application;
import ua.training.repairagency.model.entities.application.ApplicationImpl;
import ua.training.repairagency.model.entities.user.User;

public class ApplicationUtil {

	public static Application create(HttpServletRequest request) {
		Application application = new ApplicationImpl();
		application.setStatus(AppStatus.NEW);
		application.setDescription(request.getParameter(DESCRIPTION));
		application.setCustomer((User)(request.getSession().getAttribute(USER)));
		
		return application;
		
	}

}
