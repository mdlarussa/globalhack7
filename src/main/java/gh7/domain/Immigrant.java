package gh7.domain;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@DiscriminatorValue("I")
public class Immigrant extends User {

    public Immigrant() {
    }

    public Immigrant(String name, String email) {
        super(name, email);
    }
}
