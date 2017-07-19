package uk.tryzub.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.tryzub.dao.interfaces.PostDAO;
import uk.tryzub.entities.Dating;
import uk.tryzub.entities.Post;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by tszin on 18/07/2017.
 */

@Component
public class PostDAOimpl implements PostDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Post> posts;


    public List<Post> getPosts() {
        Session session = sessionFactory.openSession();
        System.out.println(session.getSessionFactory().getStatistics());

        System.out.println(session.isConnected());


        CriteriaBuilder builder = session.getCriteriaBuilder();
        System.out.println("builder======" + builder.toString());
        //Create Criteria
        CriteriaQuery<Post> criteria = builder.createQuery(Post.class);
        Root<Post> postRoot = criteria.from(Post.class);
        criteria.select(postRoot);

        //Use criteria to query with session to fetch all contacts
        posts = session.createQuery(criteria).getResultList();

        //Close session
        session.close();
        System.out.println(session.isConnected());
        System.out.println(sessionFactory.getStatistics());
        System.out.println(posts.get(1).getDate());
        return posts;

    }

    public List<Post> getPosts(int topicid) {
        return null;
    }

    public List<Post> getPosts(String postauthor) {
        return null;
    }
}
