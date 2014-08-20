package epam.com.facade;

import epam.com.DAO.ShelfDAO;
import epam.com.entity.Shelf;

import javax.ejb.Stateless;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Andrey_Bindyuk on 7/17/2014.
 */
@Stateless
public class ShelfFacadeBean implements ShelfFacade {

    @Inject
    private ShelfDAO shelfDAO;

    public ShelfFacadeBean() {
    }

    @Override
    public Shelf find(Long id) {
        return shelfDAO.find(id);
    }

    @Override
    public List<Shelf> findAll() {
        return shelfDAO.findAll();
    }
}
