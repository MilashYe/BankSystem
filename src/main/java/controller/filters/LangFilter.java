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
		Optional<String> optSession =
				Optional.ofNullable((String) ((HttpServletRequest) request).getSession().getAttribute("lang"));
		Optional<String> optReq = Optional.ofNullable(request.getParameter("locale"));
		String locale = "en";
		locale = optSession.orElse(locale);
		locale = optReq.orElse(locale);

		log.info("locale= " + locale);
		req.getSession().setAttribute("lang",
				locale);

		chain.doFilter(request,response);
	}

	@Override
	public void destroy() {

	}
}
