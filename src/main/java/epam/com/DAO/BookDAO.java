package epam.com.DAO;

import epam.com.entity.Book;

import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Andrey_Bindyuk on 8/15/2014.
 */
@Stateless
public class BookDAO extends AbstractDAO<Book, Serializable> {

    public BookDAO(Class<Book> entityTClass) {
        super(entityTClass);
    }

    public BookDAO() {
        super(Book.class);
    }

    public List<Book> findByAuthor(String author) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("author", author);
        List<Book> books = findByNamedQuery(Book.FIND_BY_AUTHOR, params);
        return books;
    }

    public List<Book> findByShelf(Long id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        List<Book> books = findByNamedQuery(Book.FIND_BY_SHELF, params);
        return books;
    }

    @Override
    public List<Book> findAll() {
        Map<String, Object> params = new HashMap<String, Object>();
        List<Book> books = findByNamedQuery(Book.FIND_ALL, params);
        return books;
    }
}
