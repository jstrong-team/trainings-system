package com.exadel.jstrong.web.fortrainings.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sergey Nalivko.
 */
@WebFilter("/ui/*")
public class AuthenticationFilter implements Filter {

    public static final String COOKIE_TOKEN = "authtoken";
    public static final String COOKIE_REMEMBER_ME = "remmeflg";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Cookie[] cookies = ((HttpServletRequest) request).getCookies();
        Map<String, Cookie> cookieMap = cookiesToMap(cookies);

        if (cookieMap.isEmpty()) {      //if no cookies
            chain.doFilter(request, response);
        }

        Cookie tokenCookie = cookieMap.get("JSESSIONID");
        Cookie remMeCookie = cookieMap.get(COOKIE_REMEMBER_ME);
        boolean isValidSession = checkSessionFor(tokenCookie);
        if (isValidSession) {
            chain.doFilter(request, response);
            return;
        }
        boolean isRememberMeValid = checkIsRemembered(remMeCookie);
        if (isRememberMeValid) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendRedirect("/ui/index.html");//.forward(request, response);
        }
    }

    /**
     * Checks whether the session for the current cookie is valid
     * @param tokenCookie the cookie with id token (JSESSIONID now)
     * @return true if session is valid and false otherwise
     */
    private boolean checkSessionFor(Cookie tokenCookie) {
        return true;
    }

    /**
     * Checks whether the token for the current cookie is valid
     * @param remMeCookie the cookie with rememberMe token
     * @return true if remember token is valid and false otherwise
     */
    private boolean checkIsRemembered(Cookie remMeCookie) {
        return true;
    }

    private Map<String, Cookie> cookiesToMap(Cookie[] cookies) {
        Map<String, Cookie> cookieMap = new HashMap<>();
        if (cookies == null) {
            return cookieMap;
        }
        for (Cookie cookie : cookies) {
            cookieMap.put(cookie.getName(), cookie);
        }
        return cookieMap;
    }

    @Override
    public void destroy() {
    }
}
