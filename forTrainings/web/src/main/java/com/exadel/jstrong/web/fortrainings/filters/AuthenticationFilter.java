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
//    public static final String COOKIE_REMEMBER_ME = "remmeflg";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Cookie[] cookies = ((HttpServletRequest) request).getCookies();
        Map<String, Cookie> cookieMap = cookiesToMap(cookies);
        String url = ((HttpServletRequest) request).getRequestURI();
        System.out.println(url);

        if (cookieMap.isEmpty()) {
            if (isBaseUrl(url)) {
                chain.doFilter(request, response);
                return;
            } else {
                ((HttpServletResponse) response).sendRedirect("/ui");
            }
            return;
        }
        Cookie tokenAuthenticate = cookieMap.get(COOKIE_TOKEN);

        boolean isDoFilter = false;
        boolean isBaseUrl = isBaseUrl(url);
        String redirectUrl = "";

        if(isBaseUrl){
            if(tokenAuthenticate != null) {
                redirectUrl = "/ui/trainings";
            } else {
                isDoFilter = true;
            }
        } else {
            if(tokenAuthenticate != null) {
                isDoFilter = true;
            } else {
                redirectUrl = "/ui";
            }
        }

        if (isDoFilter) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendRedirect(redirectUrl);
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
