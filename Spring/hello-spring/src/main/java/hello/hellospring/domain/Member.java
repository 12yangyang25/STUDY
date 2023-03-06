package hello.hellospring.domain;

import jakarta.persistence.*;

@Entity //JPA가 관리하는 엔티티
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //DB가 알아서 생성해주는 것 => 아이덴티티
    private Long id;

    @Column(name="name")
    private  String name;

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
