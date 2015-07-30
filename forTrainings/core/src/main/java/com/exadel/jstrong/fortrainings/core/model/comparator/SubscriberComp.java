package com.exadel.jstrong.fortrainings.core.model.comparator;

import com.exadel.jstrong.fortrainings.core.model.Event;
import com.exadel.jstrong.fortrainings.core.model.Subscribe;

import java.util.Comparator;

/**
 * Created by maksim on 30.07.2015.
 */
public class SubscriberComp implements Comparator<Subscribe> {
    @Override
    public int compare(Subscribe firstSubscribe, Subscribe secondSubscribe){
        try {
            return firstSubscribe.getAddDate().compareTo(secondSubscribe.getAddDate());
        } catch(Exception e){
            return 0;
        }
    }
}
