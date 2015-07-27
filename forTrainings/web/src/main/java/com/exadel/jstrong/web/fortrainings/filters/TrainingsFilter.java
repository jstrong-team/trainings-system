package com.exadel.jstrong.web.fortrainings.filters;

import com.exadel.jstrong.fortrainings.core.dao.TrainingDAO;
import com.exadel.jstrong.fortrainings.core.dao.impl.TrainingDAOImpl;
import com.exadel.jstrong.web.fortrainings.controller.EmployeeController;
import com.exadel.jstrong.web.fortrainings.controller.TrainingsController;
import com.exadel.jstrong.web.fortrainings.util.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by Администратор on 26.07.2015.
 */

public class TrainingsFilter extends OncePerRequestFilter {
    @Autowired
    private EmployeeController ec;
    @Autowired
    private TrainingsController tc;

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Map<String, Cookie> cookies = CookieUtil.cookiesToMap(request.getCookies());
        int userId = ec.getIdByToken(cookies.get(CookieUtil.TOKEN).getValue());
        String url = request.getRequestURI();
        if(!isCorrectURL(url)) {
            filterChain.doFilter(request, response);
        }
        String token = CookieUtil.getTokenURL(url);
        int trainingId = CookieUtil.getTrainingIdFromURL(url);
        String redirectUrl;
        if(false) {         //admin!!!
            redirectUrl = "/ui/trainingPage/admin/" + token;
        } else if(tc.isTrainer(userId, trainingId)) {
            redirectUrl = "/ui/trainingPage/trainer/" + token;
        } else {
            redirectUrl = "/ui/trainingPage/user/" + token;
        }
        response.sendRedirect(redirectUrl);
    }

    public boolean isCorrectURL(String url) {
        StringTokenizer st = new StringTokenizer(url, "/");
        ArrayList<String> al = new ArrayList<>();
        while(st.hasMoreTokens()) {
            al.add(st.nextToken());
        }
        return al.contains("trainingPage");
    }
}
