package epam.com.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Andrey_Bindyuk on 7/10/2014.
 */
@MappedSuperclass
public abstract class Entity implements Serializable {
    private static final long serialVersionUID = 8027089491750407462L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
