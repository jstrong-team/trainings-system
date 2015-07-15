package com.exadel.jstrong.web.fortrainings.util;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Sergey Nalivko.
 */
public class ServletUtils {

    /**
     * Writes data from thegiven file to response's output stream
     * @param req request object
     * @param res response object
     * @param path path to file to be send in responce
     * @throws IOException
     */
    public static void writeFileDataToResponse(ServletRequest req, ServletResponse res, String path) throws IOException {
        byte[] buf = new byte[1024];
        InputStream inputStream = req.getServletContext().getResourceAsStream(path);
        int read = -1;
        while ((read = inputStream.read(buf)) != -1) {
            res.getOutputStream().write(buf, 0, read);
        }
        inputStream.close();
    }
}
