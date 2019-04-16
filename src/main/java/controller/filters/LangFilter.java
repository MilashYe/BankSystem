package controller.filters;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

@WebFilter(urlPatterns = "/*")
public class LangFilter implements Filter {


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		Logger log = Logger.getLogger(this.getClass());
		HttpServletRequest req = (HttpServletRequest) request;
		String locale = Optional.ofNullable(request.getParameter("locale")).orElse("en");

		log.info("locale= " + locale);
		req.getSession().setAttribute("lang",
				locale);

		chain.doFilter(request,response);
	}

	@Override
	public void destroy() {

	}
}
