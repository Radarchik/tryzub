package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by tszin on 12/07/2017.
 */
@Entity
public class Post {
    private int postid;
    private String text;
    private Timestamp date;

    @Id
    @Column(name = "postid")
    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    @Basic
    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "date")
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
        if (text != null ? !text.equals(post.text) : post.text != null) return false;
        if (date != null ? !date.equals(post.date) : post.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = postid;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
