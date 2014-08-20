package epam.com.DAO;

import epam.com.entity.Shelf;

import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Andrey_Bindyuk on 8/15/2014.
 */
@Stateless
public class ShelfDAO extends AbstractDAO<Shelf, Serializable> {

    public ShelfDAO(Class<Shelf> entityTClass) {
        super(entityTClass);
    }

    public ShelfDAO() {
        super(Shelf.class);
    }

    @Override
    public List<Shelf> findAll() {
        Map<String, Object> params = new HashMap<String, Object>();
        List<Shelf> shelves = findByNamedQuery(Shelf.FIND_ALL, params);
        return shelves;
    }
}
