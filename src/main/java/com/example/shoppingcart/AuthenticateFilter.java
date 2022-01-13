package com.example.shoppingcart;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "AuthenticateFilter")
public class AuthenticateFilter implements Filter {
    FilterConfig filterConfig = null;
    public void init(FilterConfig config) throws ServletException {
        filterConfig = config;
    }

    public void destroy() {
        filterConfig = null;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        /**
         * Tried to implement a filter which prevents unauthenticated users to access the /mycart servlet,
         * it works for most of the parts, but after log in it is not showing the actual mycart servlet is
         * not working for some reason. Author followed the same code as the course teacher.
         */
        /*HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        String url = req.getRequestURL().toString();

        if ( url.endsWith("mycart"))
        {
            if (session==null || session.getAttribute("currentUser")==null)
            {
                RequestDispatcher rd = req.getRequestDispatcher("login.html");
                PrintWriter out = res.getWriter();
                out.println("<h1> Invalid session. Please log in again. " +
                        "</h1>");
                rd.include(req, response);
            }
        }
        else */
        chain.doFilter(request, response);
    }
}
