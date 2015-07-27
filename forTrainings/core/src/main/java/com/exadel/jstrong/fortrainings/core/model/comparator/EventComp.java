package com.exadel.jstrong.fortrainings.core.model.comparator;

import com.exadel.jstrong.fortrainings.core.model.Event;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by Anton on 27.07.2015.
 */
public class EventComp implements Comparator<Event> {

    @Override
    public int compare(Event firstEvent, Event secondEvent){
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date firstDate = dateFormat.parse(firstEvent.getDate());
            Date secondDate = dateFormat.parse(secondEvent.getDate());
            return secondDate.compareTo(firstDate);
        } catch(Exception e){
            return 0;
        }
    }

}
