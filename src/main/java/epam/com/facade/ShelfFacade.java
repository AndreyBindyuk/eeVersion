package epam.com.facade;

import epam.com.entity.Shelf;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by Andrey_Bindyuk on 7/16/2014.
 */
@Local
public interface ShelfFacade extends BaseFacade<Shelf, Long> {

    public List<Shelf> findAll();
}
