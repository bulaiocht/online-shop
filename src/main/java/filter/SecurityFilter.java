package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;
import java.util.Optional;

@WebFilter(filterName = "securityFilter", urlPatterns = {"/users/*"})
public class SecurityFilter implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        Optional<Principal> opt = Optional.ofNullable((Principal) req.getSession().getAttribute("principal"));
    }
}
