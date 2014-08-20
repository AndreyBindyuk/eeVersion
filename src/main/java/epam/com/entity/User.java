package epam.com.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Andrey_Bindyuk on 7/10/2014.
 */
@javax.persistence.Entity
@Table(name = "USERS")
@NamedQueries({
        @NamedQuery(name = User.FIND_BY_LOGIN, query = "SELECT u FROM User u  WHERE u.login = :login"),
        @NamedQuery(name = User.FIND_ALL, query = "SELECT u FROM User u")
})
public class User extends Entity implements Serializable {
    private static final long serialVersionUID = -8366854057034305431L;

    public static final String FIND_BY_LOGIN = "User.findByLogin";
    public static final String FIND_ALL = "User.findAll";

    @Column(name = "password")
    private String password;

    @Column(nullable = false, name = "login")
    private String login;

    @Column(name = "email")
    private String email;

    @Column(name = "status")
    private boolean status = true;

    @ManyToOne
    @JoinTable(name = "USERS_ROLE", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "ID"))
    private Role role;

    @Column(name = "total")
    private double total;

    public User() {
    }

    public User(String password, String login, String email, boolean status, Role role, double total) {
        this.password = password;
        this.login = login;
        this.email = email;
        this.status = status;
        this.role = role;
        this.total = total;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        role.setId(1);
        this.role = role;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


}
