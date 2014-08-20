package epam.com.facade;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Andrey_Bindyuk on 7/16/2014.
 */
public interface BaseFacade<T, PK extends Serializable> {

    T find(PK id);

    List<T> findAll();
}
