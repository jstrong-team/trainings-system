package com.exadel.jstrong.web.fortrainings.filters;

import com.exadel.jstrong.web.fortrainings.util.*;
import javax.servlet.Filter;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

@WebFilter("/forTrainings/trainings/*")
public class AuthorizationFilter implements Filter {
    private static Logger logger = Logger.getLogger(AuthorizationFilter.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String param = request.getParameter("param");
        if(!"block".equals(param)) {
            chain.doFilter(httpServletRequest, response);
            return;
        }

       /* String data = AppUtil.getFilterRequestBody(request);
        JsonElement jsonElement = new JsonParser().parse(data);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        jsonObject = jsonObject.getAsJsonObject("param");
        String param = jsonObject.toString();
        try {
            JSONObject json = AppUtil.stringToJson(data);
            Object param = json.get("param");
            logger.info("param: " + param);

        } catch (ParseException e) {}*/

    }

    @Override
    public void destroy() {

    }
}
