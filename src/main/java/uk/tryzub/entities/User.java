package uk.tryzub.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by tszin on 18/07/2017.
 */
@Entity
public class User {
    private int userid;
    private String username;
    private String email;
    private String password;
    private Timestamp creationtime;
    private String avatar;
    private String city;
    private Integer quantity;
    private Integer reputation;
    private String sign;
    private Collection<Post> postsByUsername;
    private Collection<Topic> topicsByUsername;

    @Basic
    @Column(name = "userid", nullable = false)
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Id
    @Column(name = "username", nullable = false, length = 16)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 32)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "creationtime", nullable = true)
    public Timestamp getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(Timestamp creationtime) {
        this.creationtime = creationtime;
    }

    @Basic
    @Column(name = "avatar", nullable = true, length = 255)
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 45)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "quantity", nullable = true)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "reputation", nullable = true)
    public Integer getReputation() {
        return reputation;
    }

    public void setReputation(Integer reputation) {
        this.reputation = reputation;
    }

    @Basic
    @Column(name = "sign", nullable = true, length = 100)
    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userid != user.userid) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (creationtime != null ? !creationtime.equals(user.creationtime) : user.creationtime != null) return false;
        if (avatar != null ? !avatar.equals(user.avatar) : user.avatar != null) return false;
        if (city != null ? !city.equals(user.city) : user.city != null) return false;
        if (quantity != null ? !quantity.equals(user.quantity) : user.quantity != null) return false;
        if (reputation != null ? !reputation.equals(user.reputation) : user.reputation != null) return false;
        if (sign != null ? !sign.equals(user.sign) : user.sign != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (creationtime != null ? creationtime.hashCode() : 0);
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (reputation != null ? reputation.hashCode() : 0);
        result = 31 * result + (sign != null ? sign.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByPostauthor")
    public Collection<Post> getPostsByUsername() {
        return postsByUsername;
    }

    public void setPostsByUsername(Collection<Post> postsByUsername) {
        this.postsByUsername = postsByUsername;
    }

    @OneToMany(mappedBy = "userByTopicauthor")
    public Collection<Topic> getTopicsByUsername() {
        return topicsByUsername;
    }

    public void setTopicsByUsername(Collection<Topic> topicsByUsername) {
        this.topicsByUsername = topicsByUsername;
    }
}
