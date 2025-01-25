package vn.aptech.servlet.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(
        filterName = "CustomFilter",
        displayName = "Custom Filter",
        description = "Custom filter for any things",
        urlPatterns = {"/change-color-servlet/*", "/visit-count-servlet/*"},
        initParams = {
                @WebInitParam(name = "url", value = "jdbc://mysql:localhost:3306/mydb"),
                @WebInitParam(name = "username", value = "root"),
                @WebInitParam(name = "password", value = "123456")
        }
)
public class CustomFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CustomFilter init");

        String url = filterConfig.getInitParameter("url");
        String username = filterConfig.getInitParameter("username");
        String password = filterConfig.getInitParameter("password");

        System.out.println("url: " + url + ", username: " + username + ", password: " + password);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("CustomFilter doFilter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String params  = request.getQueryString();
        String requestURL = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();

        System.out.println("requestURL: " + requestURL + ", params: " + params + ", ip: " + ip);


        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("CustomFilter destroy");
    }
}
