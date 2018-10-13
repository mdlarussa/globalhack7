package gh7.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@Entity
public class Need {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    private String description;
    @ManyToMany(mappedBy = "needs")
    private List<User> users;

    public Need() {
    }

    public Need(String description) {
        this.description = description;
    }
}
