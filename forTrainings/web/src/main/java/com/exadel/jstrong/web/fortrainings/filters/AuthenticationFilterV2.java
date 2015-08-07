package com.exadel.jstrong.web.fortrainings.filters;

import com.exadel.jstrong.fortrainings.core.dao.TokenDAO;
import com.exadel.jstrong.web.fortrainings.controller.EmployeeController;
import com.exadel.jstrong.web.fortrainings.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


public class AuthenticationFilterV2 extends OncePerRequestFilter {

    public static final String COOKIE_TOKEN = "token";
    public static final String COOKIE_SESSION = "session";
    public static final String UI_PATH = "/ui";

    @Autowired
    private EmployeeController ec;
    @Autowired
    private TokenDAO tokenDAO;

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        // allow authorization requests
        if (isLoginRequest(request)) {
            chain.doFilter(request, response);
            return;
        }

        Cookie[] cookies = request.getCookies();
        Map<String, Cookie> cookieMap = CookieUtil.cookiesToMap(cookies);
        String url = request.getRequestURI();

        boolean isCorrect = false;
        boolean isBaseUrl = isBaseUrl(url);

        boolean authorized = false;
        boolean restRequest = request.getRequestURI().startsWith("/rest");

        String redirectUrl = UI_PATH;
        if (cookieMap.isEmpty()) {
            authorized = isBaseUrl;
        } else {
            Cookie token = cookieMap.get(COOKIE_TOKEN);
            Cookie session = cookieMap.get(COOKIE_SESSION);

            if (session != null && ec.checkSession(session.getValue())){
                isCorrect = true;
                session.setMaxAge(CookieUtil.ALLOW_DELAY);
                session.setPath("/");
                response.addCookie(session);
            } else {
                isCorrect = (token != null && ec.checkToken(token.getValue()));
            }

            if (isBaseUrl) {
                if (isCorrect) {
                    //isExternal redirect!!!
                    redirectUrl = "/ui/trainings";
                } else {
                    authorized = true;
                }
            } else {
                if (isCorrect) {
                    authorized = true;
                    //
                } else {
                    redirectUrl = UI_PATH;
                }
            }
        }

        if (!authorized) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            if (restRequest) {
                return;
            }
            response.sendRedirect(redirectUrl);
        } else {
            chain.doFilter(request, response);
        }

    }

    private boolean isLoginRequest(HttpServletRequest request) {
        return request.getRequestURI().equals("/rest/login");
    }

    private boolean isBaseUrl(String url) {
        return url.equals("/ui") || url.equals("/ui/");
    }

    /**
     * Checks whether the session for the current cookie is valid
     *
     * @param tokenCookie the cookie with id token (JSESSIONID now)
     * @return true if session is valid and false otherwise
     */
    private boolean checkSessionFor(Cookie tokenCookie) {
        return true;
    }

    /**
     * Checks whether the token for the current cookie is valid
     *
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
