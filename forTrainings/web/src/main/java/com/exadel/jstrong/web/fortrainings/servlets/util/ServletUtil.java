package com.exadel.jstrong.web.fortrainings.servlets.util;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

public final class ServletUtil {
    public static final String APPLICATION_JSON = "application/json";
    public static final String UTF_8 = "UTF-8";

    private ServletUtil() {
    }

    public static String getEmployeeBody(HttpServletRequest request) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }

    public static JSONObject stringToJson(String data) throws ParseException {
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(data.trim());
    }

}
