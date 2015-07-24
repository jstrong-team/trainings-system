package com.exadel.jstrong.fortrainings.core.dao.impl;

import com.exadel.jstrong.fortrainings.core.dao.BaseDAO;
import com.exadel.jstrong.fortrainings.core.dao.SubscribeDAO;
import com.exadel.jstrong.fortrainings.core.model.Subscribe;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Anton on 23.07.2015.
 */
@Service
public class SubscribeDAOImpl extends BaseDAO<Subscribe> implements SubscribeDAO {

    @Override
    @Transactional
    public boolean addSubscribe(Subscribe subscribe){
        return super.save(subscribe);
    }

}
