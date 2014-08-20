package epam.com.facade;

import epam.com.entity.User;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by Andrey_Bindyuk on 7/18/2014.
 */
@Local
public interface UserFacade extends BaseFacade<User, Long> {

    public List<User> findAll();

    public List<User> findByLogin(String login);
}
