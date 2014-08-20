package epam.com.facade;

import epam.com.DAO.UserDAO;
import epam.com.entity.Role;
import epam.com.entity.User;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Model;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Set;

/**
 * Created by Andrey_Bindyuk on 7/18/2014.
 */
@Stateless
public class UserFacadeBean implements UserFacade {
    @Inject
    private UserDAO userDAO;

    private User user;

    public UserFacadeBean() {
    }

    public UserFacadeBean(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void create() {
        userDAO.create(user);
    }

    @Override
    public User find(Long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public List<User> findByLogin(String login) {
        return null;
    }

}
