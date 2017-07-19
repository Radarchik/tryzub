package uk.tryzub.dao.interfaces;

import uk.tryzub.entities.Post;

import java.util.List;

/**
 * Created by tszin on 18/07/2017.
 */
public interface PostDAO {

    List<Post> getPosts();
    List<Post> getPosts(int topicid);
    List<Post>  getPosts(String postauthor);

}
