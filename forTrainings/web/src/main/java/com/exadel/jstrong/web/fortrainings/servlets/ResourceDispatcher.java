package com.exadel.jstrong.web.fortrainings.servlets;

import com.exadel.jstrong.web.fortrainings.util.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Sergey Nalivko.
 */
@WebServlet("/res/*")
public class ResourceDispatcher extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String uri = ((HttpServletRequest) req).getRequestURI();
        try {
            ServletUtils.writeFileDataToResponse(req, res, uri);
        } catch (Throwable e) {
            ((HttpServletResponse) res).setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
