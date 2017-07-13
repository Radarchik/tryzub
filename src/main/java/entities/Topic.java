package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by tszin on 12/07/2017.
 */
@Entity
public class Topic {
    private String name;
    private Integer answers;
    private Integer views;
    private String last;
    private int topicid;

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "answers")
    public Integer getAnswers() {
        return answers;
    }

    public void setAnswers(Integer answers) {
        this.answers = answers;
    }

    @Basic
    @Column(name = "views")
    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    @Basic
    @Column(name = "last")
    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Id
    @Column(name = "topicid")
    public int getTopicid() {
        return topicid;
    }

    public void setTopicid(int topicid) {
        this.topicid = topicid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Topic topic = (Topic) o;

        if (topicid != topic.topicid) return false;
        if (name != null ? !name.equals(topic.name) : topic.name != null) return false;
        if (answers != null ? !answers.equals(topic.answers) : topic.answers != null) return false;
        if (views != null ? !views.equals(topic.views) : topic.views != null) return false;
        if (last != null ? !last.equals(topic.last) : topic.last != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (answers != null ? answers.hashCode() : 0);
        result = 31 * result + (views != null ? views.hashCode() : 0);
        result = 31 * result + (last != null ? last.hashCode() : 0);
        result = 31 * result + topicid;
        return result;
    }
}
