package com.exadel.jstrong.fortrainings.core.model.comparator;

import com.exadel.jstrong.fortrainings.core.model.Event;

import java.util.Comparator;

/**
 * Created by Anton on 27.07.2015.
 */
public class EventComp implements Comparator<Event> {

    @Override
    public int compare(Event firstEvent, Event secondEvent){
        try {
            return secondEvent.getDate().compareTo(firstEvent.getDate());
        } catch(Exception e){
            return 0;
        }
    }

}
