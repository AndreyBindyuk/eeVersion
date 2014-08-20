package epam.com.facade;

import epam.com.DAO.BookDAO;
import epam.com.entity.Book;

import javax.ejb.Stateless;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Andrey_Bindyuk on 7/17/2014.
 */
@Stateless
public class BookFacadeBean implements BookFacade {

    @Inject
    private BookDAO bookDAO;

    public BookFacadeBean() {
    }

    @Override
    public List<Book> findByShelf(Long id) {
        return bookDAO.findByShelf(id);
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return bookDAO.findByAuthor(author);
    }

    @Override
    public Book find(Long id) {
        return bookDAO.find(id);
    }

    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }
}
