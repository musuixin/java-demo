package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebFilter(filterName = "LoginFilter",
        urlPatterns = {
                "/success/*"
        }

)
public class LoginFilter implements Filter {
    private static Logger log = Logger.getLogger("LoginFilter");
    private String filterName = "LoginFilter";

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String name = (String) request.getSession().getAttribute("uname");
        if (name == null) {
            request.setAttribute("str", "ÇëÏÈµÇÂ½");
            request.getRequestDispatcher("/SignIn.html").forward(request, response);
        } else {
            chain.doFilter(req, resp);
        }
    }
}
