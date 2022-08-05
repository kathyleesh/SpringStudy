package hello.practicespring.domain;

import javax.persistence.*;

@Entity //JPA가 관리하는 entity임을 명시
public class Member {

    //@Id == Pk, @GeneratedValue(strategy = GenerationType.IDENTITY) == AI
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "username")
    private String name;

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
