package com.exadel.jstrong.web.fortrainings.model.status;

/**
 * Created by Anton on 31.07.2015.
 */
public class NoticeStatus {

    public static final String WARNING = "warning";
    public static final String SUCCESS = "success";
    public static final String INFO = "info";

    public static int getStatusPriority(String status){
        if (status.equals(WARNING)){
            return 3;
        }
        if (status.equals(INFO)){
            return 2;
        }
        if (status.equals(SUCCESS)){
            return 1;
        }
        return 0;
    }

}
