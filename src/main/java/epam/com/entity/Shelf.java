package epam.com.entity;

import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Andrey_Bindyuk on 7/15/2014.
 */
@javax.persistence.Entity
@Table(name = "SHELF")
@NamedQueries({
        @NamedQuery(name = Shelf.FIND_ALL, query = "SELECT s FROM Shelf s")
})
public class Shelf extends Entity implements Serializable {

    private static final long serialVersionUID = 3248342112680642647L;
    public static final String FIND_ALL = "Shelf.findAll";
    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "genre")
    private String genre;

    @Column(name = "number_of_books")
    private Integer numberOfBooks;

    public Shelf() {
    }

    public Shelf(String name, String genre, Integer numberOfBooks) {
        super();
        this.name = name;
        this.genre = genre;
        this.numberOfBooks = numberOfBooks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(Integer numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }
}
