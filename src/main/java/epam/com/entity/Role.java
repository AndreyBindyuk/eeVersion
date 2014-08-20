package epam.com.entity;

import javax.inject.Named;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Andrey_Bindyuk on 7/10/2014.
 */
@javax.persistence.Entity
@Table(name = "ROLE")
public class Role extends Entity implements Serializable {
    private static final long serialVersionUID = 1503792993892674184L;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "role")
    private Set<User> user;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
