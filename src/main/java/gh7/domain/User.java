package gh7.domain;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@DiscriminatorColumn(name="Type")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class User {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    private String name;
    private String email;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "need_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id",
                    referencedColumnName = "id"))
    private List<Need> needs;

    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void addNeed(Need need) {
        if (this.needs == null) {
            this.needs = new ArrayList<>();
        }
        this.needs.add(need);
    }
}
