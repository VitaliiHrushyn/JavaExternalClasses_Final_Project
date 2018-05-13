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
import javax.servlet.http.HttpServletResponse;

import ua.training.repairagency.controller.constants.URL;

@WebFilter(urlPatterns=URL.FILTER_PATTERN)
public class EncodingAndCacheFilter implements Filter {

	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) response;
		
		request.setCharacterEncoding(UTF_8);
		res.setCharacterEncoding(UTF_8);
		res.setContentType(TEXT_HTML);
		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); /* HTTP 1.1 */
		res.setHeader("Pragma", "no-cache"); /* HTTP 1.0 */
		res.setDateHeader("Expires", 0); /* Proxies */
		filterChain.doFilter(request, response);		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}	

}
