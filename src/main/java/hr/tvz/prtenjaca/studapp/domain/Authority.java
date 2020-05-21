package hr.tvz.prtenjaca.studapp.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "user_authority",
            joinColumns = { @JoinColumn(name = "USER_ID") },
            inverseJoinColumns = { @JoinColumn(name = "AUTHORITY_ID") })
    private Set<User> users;

    public Authority(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
