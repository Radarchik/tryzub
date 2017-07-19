package uk.tryzub.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by tszin on 18/07/2017.
 */
@Entity
public class Topic {
    private int topicid;
    private String name;
    private String topicauthor;
    private Integer answers;
    private Integer views;
    private String last;
    private Collection<Post> postsByTopicid;
    private User userByTopicauthor;

    @Id
    @Column(name = "topicid", nullable = false)
    public int getTopicid() {
        return topicid;
    }

    public void setTopicid(int topicid) {
        this.topicid = topicid;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "topicauthor", nullable = false, length = 16, insertable = false, updatable = false)
    public String getTopicauthor() {
        return topicauthor;
    }

    public void setTopicauthor(String topicauthor) {
        this.topicauthor = topicauthor;
    }

    @Basic
    @Column(name = "answers", nullable = true)
    public Integer getAnswers() {
        return answers;
    }

    public void setAnswers(Integer answers) {
        this.answers = answers;
    }

    @Basic
    @Column(name = "views", nullable = true)
    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    @Basic
    @Column(name = "last", nullable = true, length = 45)
    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Topic topic = (Topic) o;

        if (topicid != topic.topicid) return false;
        if (name != null ? !name.equals(topic.name) : topic.name != null) return false;
        if (topicauthor != null ? !topicauthor.equals(topic.topicauthor) : topic.topicauthor != null) return false;
        if (answers != null ? !answers.equals(topic.answers) : topic.answers != null) return false;
        if (views != null ? !views.equals(topic.views) : topic.views != null) return false;
        if (last != null ? !last.equals(topic.last) : topic.last != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = topicid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (topicauthor != null ? topicauthor.hashCode() : 0);
        result = 31 * result + (answers != null ? answers.hashCode() : 0);
        result = 31 * result + (views != null ? views.hashCode() : 0);
        result = 31 * result + (last != null ? last.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "topicByTopicid")
    public Collection<Post> getPostsByTopicid() {
        return postsByTopicid;
    }

    public void setPostsByTopicid(Collection<Post> postsByTopicid) {
        this.postsByTopicid = postsByTopicid;
    }

    @ManyToOne
    @JoinColumn(name = "topicauthor", referencedColumnName = "username", nullable = false)
    public User getUserByTopicauthor() {
        return userByTopicauthor;
    }

    public void setUserByTopicauthor(User userByTopicauthor) {
        this.userByTopicauthor = userByTopicauthor;
    }
}
