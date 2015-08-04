package com.exadel.jstrong.web.fortrainings.util;

import javax.servlet.http.Cookie;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Anton on 17.07.2015.
 */
public class CookieUtil {

    public static final int ALLOW_DELAY = 4;

    public static final String TOKEN = "token";
    public static final String SESSION = "session";

    public static String generateToken (){
        StringBuilder token = new StringBuilder();
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("ddMMyyHHmmss");
        int number = (new Random()).nextInt();
        token.append(df.format(date)).append(Integer.toString(number));
        return token.toString();
    }

    public static Map<String, Cookie> cookiesToMap(Cookie[] cookies) {
        Map<String, Cookie> cookieMap = new HashMap<>();
        if (cookies == null) {
            return cookieMap;
        }
        for (Cookie cookie : cookies) {
            cookieMap.put(cookie.getName(), cookie);
        }
        return cookieMap;
    }

    public static int getTrainingIdFromURL(String url) {
        String token = url.substring(url.lastIndexOf('/') + 1, url.length());
        return (Integer.valueOf(token));
    }

    public static String getTokenURL(String url) {
        return url.substring(url.lastIndexOf('/'), url.length());
    }

    public static boolean checkDate(Date oldDate, Date newDate){
        return newDate.getTime() - oldDate.getTime() <= ALLOW_DELAY;
    }

}
