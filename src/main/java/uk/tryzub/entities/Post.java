package uk.tryzub.entities;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by tszin on 18/07/2017.
 */
@Entity
public class Post {
    private int postid;
    private int topicid;
    private String text;
    private Timestamp date;
    private Topic topicByTopicid;
    private User userByPostauthor;

    @Id
    @Column(name = "postid", nullable = false)
    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    @Basic
    @Column(name = "topicid", nullable = false, insertable = false, updatable = false)
    public int getTopicid() {
        return topicid;
    }

    public void setTopicid(int topicid) {
        this.topicid = topicid;
    }

    @Basic
    @Column(name = "text", nullable = true, length = 5000)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (postid != post.postid) return false;
        if (topicid != post.topicid) return false;
        if (text != null ? !text.equals(post.text) : post.text != null) return false;
        if (date != null ? !date.equals(post.date) : post.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = postid;
        result = 31 * result + topicid;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "topicid", referencedColumnName = "topicid", nullable = false)
    public Topic getTopicByTopicid() {
        return topicByTopicid;
    }

    public void setTopicByTopicid(Topic topicByTopicid) {
        this.topicByTopicid = topicByTopicid;
    }

    @ManyToOne
    @JoinColumn(name = "postauthor", referencedColumnName = "username", nullable = false)
    public User getUserByPostauthor() {
        return userByPostauthor;
    }

    public void setUserByPostauthor(User userByPostauthor) {
        this.userByPostauthor = userByPostauthor;
    }
}
