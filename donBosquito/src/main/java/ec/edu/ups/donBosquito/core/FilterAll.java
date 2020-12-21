package ec.edu.ups.donBosquito.core;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 
 */
public class FilterAll implements Filter {

	/**
	 * Checks if user is logged in. If not it redirects to the login.xhtml page.
	 *
	 * @param request
	 * @param response
	 * @param chain
	 * @throws java.io.IOException
	 * @throws javax.servlet.ServletException
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// Get the loginBean from session attribute
		String url = ((HttpServletRequest) request).getRequestURI();
		boolean login = false;
		if (url.endsWith("/login.xhtml") || url.endsWith("/login.jsf")) {
			login = true;
		}
		String contextPath = ((HttpServletRequest) request).getContextPath();
		if (url.contains("/javax.faces.resource/")) {
			chain.doFilter(request, response);
			return;
		}
		CtrSession loginBean = (CtrSession) ((HttpServletRequest) request).getSession().getAttribute("ctrSession");
		// For the first application request there is no loginBean in the session so
		// user needs to log in
		// For other requests loginBean is present but we need to check if user has
		// logged in successfully
		if (loginBean == null) {
			// sin loguear
			if (!login) {
				((HttpServletResponse) response).sendRedirect(contextPath + "/login.jsf");
				return;
			}
		} else {
			if (url.equals(contextPath + "/")) {
				((HttpServletResponse) response).sendRedirect(contextPath + "/dashboard.jsf");
				return;
			} else if (login) {
				((HttpServletResponse) response).sendRedirect(contextPath + "/dashboard.jsf");
				return;
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException {
		// Nothing to do here!
	}

	public void destroy() {
		// Nothing to do here!
	}

}
