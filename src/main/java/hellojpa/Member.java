package hellojpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
//@Table(name = "USER")
public class Member {
    @Id
    private Long id;
    //@Column(name = "username")
    private String name;

    public Member() {
    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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
