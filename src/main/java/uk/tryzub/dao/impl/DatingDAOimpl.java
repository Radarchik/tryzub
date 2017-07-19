package uk.tryzub.dao.impl;

import org.hibernate.Criteria;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import uk.tryzub.dao.interfaces.DatingDAO;
import uk.tryzub.entities.Dating;

import java.util.*;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Created by tszin on 14/07/2017.
 */


@Component
public class DatingDAOimpl implements DatingDAO {

    @Autowired
    private SessionFactory sessionFactory;
    public List<Dating> datings;


    public List<Dating> getDatings() {
        Session session = sessionFactory.openSession();
        System.out.println(session.getSessionFactory().getStatistics());

        System.out.println(session.isConnected());


        CriteriaBuilder builder = session.getCriteriaBuilder();
        System.out.println("builder======" + builder.toString());
        //Create Criteria
        CriteriaQuery<Dating> criteria = builder.createQuery(Dating.class);
        Root<Dating> datingRoot = criteria.from(Dating.class);
        criteria.select(datingRoot);

        //Use criteria to query with session to fetch all contacts
        datings = session.createQuery(criteria).getResultList();

        //Close session
        session.close();
        System.out.println(session.isConnected());
        System.out.println(sessionFactory.getStatistics());
        System.out.println(datings.get(4).getCity());
        return datings;

    }

    public List<Dating> getDatings(int section) {
        return null;
    }


    public List<Dating> getDatiyngs() {

        Dating d = new Dating();
        datings.add(d);

        return datings;


/*
        //Open Session
        Session session = sessionFactory.getCurrentSession();

        *//* //Deprecated Way
        * Criteria criteria = session.createCriteria(Contact.class);
        * List<Contacts> contacts = criteria.list(); *//*

        //Get Criteria Builder
        CriteriaBuilder builder = session.getCriteriaBuilder();

        //Create Criteria
        CriteriaQuery<Dating> criteria = builder.createQuery(Dating.class);
        Root<Dating> datingRoot = criteria.from(Dating.class);
        criteria.select(datingRoot);

        //Use criteria to query with session to fetch all contacts
         datings = session.createQuery(criteria).getResultList();

        //Close session
        session.close();*/

        //return datings;
    }

    @Transactional
    public List<Dating> getDatings2() {

        datings = (List<Dating>) sessionFactory.getCurrentSession()
                .createCriteria(Dating.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return datings;
    }

    public List<Dating> getDatings(Date date) {
        return null;
    }

    public List<Dating> getDatings(String city) {
        return null;
    }
}
