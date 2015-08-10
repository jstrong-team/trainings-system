package com.exadel.jstrong.web.fortrainings.services.mailservice;

import com.exadel.jstrong.fortrainings.core.model.Notice;

/**
 * Created by Anton on 09.08.2015.
 */
public class LetterFormService {

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
    private final static String TEXT_OPEN = "<p style=\"padding-left: 25px; padding-right:15px; font-size: 16px\">";
    private final static String TEXT_CLOSE = "</p>";
    private final static String LINK_OPEN = "<a href=\"";
    private final static String LINK_BODY_OPEN = "\">";
    private final static String LINK_CLOSE = "</a>";
    private final static String PAGE_CLOSE = "</div>";

    public static String getHTMLPage(Notice notice){
        StringBuilder page = new StringBuilder();
        page.append(PAGE_OPEN).append(HAT);
        page.append(THEME_OPEN).append(notice.getTheme()).append(THEME_CLOSE);
        page.append(TEXT_OPEN).append(notice.getText()).append(TEXT_CLOSE);
        if (notice.getTransactionId() != null){
            page.append(TEXT_OPEN);
            page.append(LINK_OPEN).append(getTransactionURL(notice.getTransactionId())).append(LINK_BODY_OPEN);
            page.append("Link").append(LINK_CLOSE);
        } else {
            page.append(TEXT_OPEN);
            page.append(LINK_OPEN).append(getTrainingURL(notice.getTrainingId())).append(LINK_BODY_OPEN);
            page.append("Link").append(LINK_CLOSE);
        }
        page.append(PAGE_CLOSE);
        return page.toString();
    }

    private static String getTransactionURL(int id){
        StringBuilder url = new StringBuilder("http://localhost:8080/ui/trainingPage/approve/");
        return url.append(id).toString();
    }

    private static String getTrainingURL(int id){
        StringBuilder url = new StringBuilder("http://localhost:8080/ui/trainingPage/user/");
        return url.append(id).toString();
    }

}
