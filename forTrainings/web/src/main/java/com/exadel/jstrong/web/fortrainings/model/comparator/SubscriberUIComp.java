package com.exadel.jstrong.web.fortrainings.model.comparator;

import com.exadel.jstrong.fortrainings.core.model.Subscribe;
import com.exadel.jstrong.web.fortrainings.model.SubscriberUI;

import java.util.Comparator;

/**
 * Created by Администратор on 03.08.2015.
 */
public class SubscriberUIComp implements Comparator<SubscriberUI> {
    @Override
    public int compare(SubscriberUI firstSubscribe, SubscriberUI secondSubscribe){
        try {
            return firstSubscribe.getDate().compareTo(secondSubscribe.getDate());
        } catch(Exception e){
            return 0;
        }
    }
}
