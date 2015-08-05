package com.exadel.jstrong.web.fortrainings.services;

import com.exadel.jstrong.fortrainings.core.model.Account;

/**
 * Created by Anton on 05.08.2015.
 */
public class ExternalService {

    private static final String LOGIN = "externaltrainer";

    public static Account getAccount(int id){
        Account acc = new Account();
        acc.setLogin(LOGIN + id);
        acc.setPassword(LOGIN + id);
        return acc;
    }

}
