package com.exadel.jstrong.web.fortrainings.services.mailservice;

import com.exadel.jstrong.fortrainings.core.model.Notice;
import org.apache.log4j.Logger;

import java.net.InetAddress;

/**
 * Created by Anton on 09.08.2015.
 */
public class LetterFormService {

    private static Logger logger = Logger.getLogger(LetterFormService.class);

    private final static String PAGE_OPEN = "<div style=\"border: 2px solid #032539; border-radius: 5px; font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;\">";
    private final static String HAT = "<div style=\"color:white;\n" +
            "    background-color: #032539;\n" +
            "    font-size:34px;\n" +
            "    font-style: italic;\n" +
            "    min-height: 40px;;\n" +
            "    align-items: center;\n" +
            "    font-weight:900;\">\n" +
            "        <span>\n" +
            "            Exadel<sup style=\"font-size:18px;\"><sup> &reg</sup></sup>\n" +
            "        </span>\n" +
            "    </div>";
    private final static String THEME_OPEN = "<h2 style=\"padding-left: 25px; padding-right:15px; font-size: 20px\">";
    private final static String THEME_CLOSE = "</h2>";
    private final static String TEXT_OPEN = "<p style=\"padding-left: 25px; padding-right:15px; font-size: 15px\">";
    private final static String TEXT_CLOSE = "</p>";
    private final static String LINK_OPEN = "<a href=\"";
    private final static String LINK_BODY_OPEN = "\">";
    private final static String LINK_CLOSE = "</a>";
    private final static String PAGE_CLOSE = "</div>";

    private final static String BASE_URL = "http://localhost:8080";
    private final static String TRAINING_URL = "/ui/trainingPage/user/";
    private final static String TRAINING_CREATE_URL = "/ui/trainingPage/approveCreate/";
    private final static String TRANSACTION_URL = "/ui/trainingPage/approve/";

    static {

    }

    public static String getHTMLPage(Notice notice){
        StringBuilder page = new StringBuilder();
        page.append(PAGE_OPEN).append(HAT);
        page.append(THEME_OPEN).append(notice.getTheme()).append(THEME_CLOSE);
        page.append(TEXT_OPEN).append(notice.getText()).append(TEXT_CLOSE);
        String link;
        if (notice.getTrainingId() != null){
            if (notice.isApproveTraining()) {
                link = getTrainingCreateURL(notice.getTrainingId());
            } else {
                link = getTrainingURL(notice.getTrainingId());
            }
        } else {
            if (notice.getTransactionId() != null){
                link = getTransactionURL(notice.getTransactionId());
            } else {
                link = getCurrentURL();
            }
        }
        if (link != null){
            page.append(TEXT_OPEN).append(LINK_OPEN);
            page.append(link).append(LINK_BODY_OPEN).append(link);
            page.append(LINK_CLOSE).append(TEXT_CLOSE);
        }
        page.append(PAGE_CLOSE);
        return page.toString();
    }

    private static String getTransactionURL(int id){
        StringBuilder url = new StringBuilder(getCurrentURL());
        return url.append(TRANSACTION_URL).append(id).toString();
    }

    private static String getTrainingURL(int id){
        StringBuilder url = new StringBuilder(getCurrentURL());
        return url.append(TRAINING_URL).append(id).toString();
    }

    private static String getTrainingCreateURL(int id){
        StringBuilder url = new StringBuilder(getCurrentURL());
        return url.append(TRAINING_CREATE_URL).append(id).toString();
    }

    private static String getCurrentURL(){
        try{
            String localHost = InetAddress.getLocalHost().getHostAddress();
            String url = new String(BASE_URL);
            url = url.replace("localhost", localHost);
            return url;
        } catch(Throwable e){
            logger.warn("Error");
            return BASE_URL;
        }
    }

}
