package siit.finalProject.VehicleManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import siit.finalProject.VehicleManagement.domain.User;
import siit.finalProject.VehicleManagement.service.SecurityService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class SecurityFilter implements Filter {

    @Autowired
    private SecurityService securityService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        User user = (User) ((HttpServletRequest) request).getSession().getAttribute("currentUser");

        securityService.setCurrentUser(user);

        String url = ((HttpServletRequest) request).getRequestURL().toString();

        if (url.contains("vehicle")) {
            if (user == null) {
                HttpServletResponse servletResponse = (HttpServletResponse) response;
                servletResponse.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
                servletResponse.setHeader("Location", "/login");
                return;
            }
        }
        chain.doFilter(request, response);
    }



    @Override
    public void destroy() {

    }
}

