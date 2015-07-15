package com.exadel.jstrong.web.fortrainings.servlets;

import com.exadel.jstrong.web.fortrainings.util.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * Created by Sergey Nalivko.
 */
@WebServlet("/index.html")
public class IndexServlet extends HttpServlet {
    public static final String INDEX_PAGE_PATH = "/index.html";

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        ServletUtils.writeFileDataToResponse(req, res, INDEX_PAGE_PATH);
    }

}
