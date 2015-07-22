package com.exadel.jstrong.web.fortrainings.filters;

import com.exadel.jstrong.web.fortrainings.controller.EmployeeController;
import com.exadel.jstrong.web.fortrainings.controller.impl.EmployeeControllerImpl;
import com.exadel.jstrong.web.fortrainings.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Sergey Nalivko.
 */

public class AuthenticationFilter extends OncePerRequestFilter {

    public static final String COOKIE_TOKEN = "token";
    @Autowired
    private EmployeeController ec;

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        Cookie[] cookies = request.getCookies();
        Map<String, Cookie> cookieMap = CookieUtil.cookiesToMap(cookies);
        String url = request.getRequestURI();

        boolean isCorrect = false;
        boolean isBaseUrl = isBaseUrl(url);

        if (cookieMap.isEmpty()) {
            if (isBaseUrl) {
                chain.doFilter(request, response);
                return;
            } else {
                response.sendRedirect("/ui");
            }
            return;
        }
        Cookie token = cookieMap.get(COOKIE_TOKEN);
        isCorrect = (token != null && ec.checkToken(token.getValue()));
        boolean isDoFilter = false;
        String redirectUrl = "";

        if(isBaseUrl){
            if(isCorrect) {
                redirectUrl = "/ui/trainings";
            } else {
                isDoFilter = true;
            }
        } else {
            if(isCorrect) {
                isDoFilter = true;
            } else {
                redirectUrl = "/ui";
            }
        }

        if (isDoFilter) {
            chain.doFilter(request, response);
        } else {
             response.sendRedirect(redirectUrl);
        }
    }

    private boolean isBaseUrl(String url) {
        return url.equals("/ui") || url.equals("/ui/");
    }

    /**
     * Checks whether the session for the current cookie is valid
     * @param tokenCookie the cookie with id token (JSESSIONID now)
     * @return true if session is valid and false otherwise
     */
    private boolean checkSessionFor(Cookie tokenCookie) { return true; }

    /**
     * Checks whether the token for the current cookie is valid
     * @param remMeCookie the cookie with rememberMe token
     * @return true if remember token is valid and false otherwise
     */
    private boolean checkIsRemembered(Cookie remMeCookie) {
        return true;
    }

    @Override
    public void destroy() {
    }
}
