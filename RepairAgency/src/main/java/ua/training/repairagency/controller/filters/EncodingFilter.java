package ua.training.repairagency.controller.filters;

import static ua.training.repairagency.controller.constants.AttributeOrParam.*;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import ua.training.repairagency.controller.constants.URL;

@WebFilter(urlPatterns=URL.FILTER_PATTERN)
public class EncodingFilter implements Filter {

	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		request.setCharacterEncoding(UTF_8);
		response.setCharacterEncoding(UTF_8);
		response.setContentType(TEXT_HTML);
		filterChain.doFilter(request, response);		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}	

}
