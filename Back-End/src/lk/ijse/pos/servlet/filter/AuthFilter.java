package lk.ijse.pos.servlet.filter;


import lk.ijse.pos.servlet.util.MessageUtil;

import javax.json.JsonObject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(urlPatterns = "/*",filterName = "B",initParams = {@WebInitParam(name = "order", value = "2")})
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Auth Filter Init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        System.out.println("Auth Filter Do Filter Invoked");

        String auth = req.getHeader("Auth");

        System.out.println(auth);
        if (auth != null && auth.equals("user=admin,pass=admin")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {

            res.addHeader("Content-Type", "application/json");
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

            JsonObject jsonObject = MessageUtil.genJson("Auth-Error", "You are not Authenticated to use this Service.!");
            res.getWriter().print(jsonObject);
        }

    }

    @Override
    public void destroy() {

    }
}
