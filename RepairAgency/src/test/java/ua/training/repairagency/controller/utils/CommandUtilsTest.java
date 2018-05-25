package ua.training.repairagency.controller.utils;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static ua.training.repairagency.controller.constants.AttributeOrParam.CONFIRM_PASSWORD;
import static ua.training.repairagency.controller.constants.AttributeOrParam.EMAIL;
import static ua.training.repairagency.controller.constants.AttributeOrParam.LOGIN;
import static ua.training.repairagency.controller.constants.AttributeOrParam.NAME;
import static ua.training.repairagency.controller.constants.AttributeOrParam.PASSWORD;
import static ua.training.repairagency.controller.constants.AttributeOrParam.PHONE;
import static ua.training.repairagency.controller.constants.AttributeOrParam.SURNAME;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;

import ua.training.repairagency.controller.utils.CommandUtils;

public class CommandUtilsTest {
	
	private List<String> messages = new ArrayList<>();
	
	private String login = "login";
	private String password = "password";
	private String confirmpassword = "password";
	private String name = "name";
	private String surname = "surname";
	private String email = "email@goo.com";
	private String phone = "1234567";
	private String language = "en";

	
	 private HttpServletRequest request;
	 private HttpSession session;

	@Before
	public void prepareComman() {
		request = mock(HttpServletRequest.class);
		session = mock(HttpSession.class);
		
	}
	
	@Test
	public void testCheckRegistrationCredentials() {
		when(request.getParameter(LOGIN)).thenReturn(login);
		when(request.getParameter(PASSWORD)).thenReturn(password);
		when(request.getParameter(CONFIRM_PASSWORD)).thenReturn(confirmpassword);
		when(request.getParameter(NAME)).thenReturn(name);
		when(request.getParameter(SURNAME)).thenReturn(surname);
		when(request.getParameter(EMAIL)).thenReturn(email);
		when(request.getParameter(PHONE)).thenReturn(phone);
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("language")).thenReturn(language);
		
		boolean checkCredentialsResult = CommandUtils.checkRegistrationCredentials(request, messages);
		
		assertTrue(checkCredentialsResult);
		verify(request).getParameter(PASSWORD);	
		
	}	
	
}
