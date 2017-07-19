package uk.tryzub.dao.interfaces;

import uk.tryzub.entities.User;

import java.util.List;

/**
 * Created by tszin on 18/07/2017.
 */
public interface UserDAO {
    List<User> getUsers();
    List<User> getUsers(int topicid);
    List<User>  getPosts(String postauthor);


}
