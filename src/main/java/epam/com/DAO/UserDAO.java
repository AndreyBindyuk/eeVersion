package epam.com.DAO;

import epam.com.entity.User;
import epam.com.facade.UserFacade;

import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Andrey_Bindyuk on 7/17/2014.
 */
@Stateless
public class UserDAO extends AbstractDAO<User, Serializable> implements Serializable {
    private static final long serialVersionUID = -3115754201616610037L;

    public UserDAO() {
        super();
    }

    @Override
    public void create(User entity) {
        super.create(entity);
    }


    @Override
    public List<User> findAll() {
        Map<String, Object> params = new HashMap<String, Object>();
        List<User> users = findByNamedQuery(User.FIND_ALL, params);
        return users;
    }
}
