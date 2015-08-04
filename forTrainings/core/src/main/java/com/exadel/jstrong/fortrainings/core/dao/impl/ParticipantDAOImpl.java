package com.exadel.jstrong.fortrainings.core.dao.impl;

import com.exadel.jstrong.fortrainings.core.dao.BaseDAO;
import com.exadel.jstrong.fortrainings.core.dao.ParticipantDAO;
import com.exadel.jstrong.fortrainings.core.model.Participant;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Anton on 03.08.2015.
 */
@Service
public class ParticipantDAOImpl extends BaseDAO<Participant> implements ParticipantDAO {

    @Override
    @Transactional
    public void addParticipants(List<Participant> participants) {
        saveAll(participants);
    }

    @Override
    @Transactional
    public void deleteParticipants(List<Participant> participants) {
        deleteAll(participants);
    }

    @Override
    public int contains(int subscribeId, int meetId) {
        try {
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<Participant> query = criteriaBuilder.createQuery(Participant.class);
            Root<Participant> root = query.from(Participant.class);
            Predicate p1 = criteriaBuilder.equal(root.<Integer>get("subscribeId"), subscribeId);
            Predicate p2 = criteriaBuilder.equal(root.<Integer>get("meetId"), meetId);
            query.where(criteriaBuilder.and(p1, p2));
            Participant participant = em.createQuery(query).getSingleResult();
            return participant.getId();
        } catch (Throwable e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    @Transactional
    public int updateParticipant(Participant participant) {
        int id = contains(participant.getSubscribeId(), participant.getMeetId());
        if (id != 0) {
            participant.setId(id);
        }
        return super.update(participant).getId();
    }



}
