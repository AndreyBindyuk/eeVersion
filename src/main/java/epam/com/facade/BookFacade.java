package epam.com.facade;

import epam.com.entity.Book;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by Andrey_Bindyuk on 7/16/2014.
 */
@Local
public interface BookFacade extends BaseFacade<Book, Long> {

    public List<Book> findByShelf(Long id);

    public List<Book> findByAuthor(String author);

    public List<Book> findAll();
}
