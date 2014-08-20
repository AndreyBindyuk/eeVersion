package epam.com.entity;

import javax.inject.Named;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Andrey_Bindyuk on 7/14/2014.
 */
@javax.persistence.Entity
@Table(name = "BOOK")
@NamedQueries({
        @NamedQuery(name = Book.FIND_BY_AUTHOR, query = "SELECT b FROM Book b  WHERE  b.author = :author"),
        @NamedQuery(name = Book.FIND_BY_SHELF, query = "SELECT b FROM Book  b WHERE b.shelf.id = :id"),
        @NamedQuery(name = Book.FIND_ALL, query = "SELECT s FROM Book s")
})
public class Book extends Entity implements Serializable {

    private static final long serialVersionUID = 7295599402265905986L;

    public static final String FIND_BY_AUTHOR = "Book.findByAuthor";
    public static final String FIND_BY_SHELF = "Book.findByShelf";
    public static final String FIND_ALL = "Book.findAll";

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "author")
    private String author;

    @Column(name = "number_Of_Pages")
    private Integer numberOfPages;

    @JoinColumn(name = "shelf_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Shelf shelf;

    public Book() {
    }

    public Book(String name, String author, Integer numberOfPages) {
        this.name = name;
        this.author = author;
        this.numberOfPages = numberOfPages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Shelf getShelf() {
        return shelf;
    }

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }
}
