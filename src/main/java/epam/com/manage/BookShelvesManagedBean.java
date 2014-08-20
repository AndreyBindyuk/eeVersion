package epam.com.manage;


import epam.com.entity.Book;
import epam.com.entity.Shelf;
import epam.com.facade.BookFacade;
import epam.com.facade.ShelfFacade;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Andrey_Bindyuk on 7/16/2014.
 */
@ManagedBean(name = "BookShelvesManagedBean")
@SessionScoped
public class BookShelvesManagedBean implements Serializable {
    private static final long serialVersionUID = -1569874968928805005L;

    @Inject
    private ShelfFacade shelfFacade;

    @Inject
    private BookFacade bookFacade;


    private List<Shelf> shelves;
    private List<Book> books;

    @PostConstruct
    public void initU() {
        shelves = shelfFacade.findAll();
        books = bookFacade.findAll();
    }

    public String showBookList() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext()
                .getRequestParameterMap();
        books = bookFacade.findByShelf(Long.valueOf(params.get("id")));
        return "booksListView";
    }

    public String showBooksByAuthor() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext()
                .getRequestParameterMap();
        books = bookFacade.findByAuthor(params.get("author"));
        return "booksByAuthorList";
    }

    public List<Shelf> getShelves() {
        return shelves;
    }

    public void setShelves(List<Shelf> shelves) {
        this.shelves = shelves;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
