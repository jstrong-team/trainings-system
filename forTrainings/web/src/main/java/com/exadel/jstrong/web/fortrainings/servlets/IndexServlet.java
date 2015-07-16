package com.exadel.jstrong.web.fortrainings.servlets;

import com.exadel.jstrong.web.fortrainings.util.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletResponseWrapper;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sergey Nalivko.
 */
@WebServlet("/index.html")
public class IndexServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        ((HttpServletResponse) res).sendRedirect("/ui/");
    }

}
