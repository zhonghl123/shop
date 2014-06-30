
package filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用于字符转换
 */
public class CharacterEncodingFilter implements Filter {

	private String encoding;

	private boolean forceEncoding = true;

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}


	public void setForceEncoding(boolean forceEncoding) {
		this.forceEncoding = forceEncoding;
	}


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
		if (this.encoding != null && (this.forceEncoding || servletRequest.getCharacterEncoding() == null)) {
            servletRequest.setCharacterEncoding(this.encoding);
			if (this.forceEncoding) {
                servletResponse.setCharacterEncoding(this.encoding);
			}
		}
		filterChain.doFilter(servletRequest, servletResponse);
	}
    @Override
    public void destroy() {
    }

}
