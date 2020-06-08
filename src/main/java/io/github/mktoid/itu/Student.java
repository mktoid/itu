package io.github.mktoid.itu;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;

@Entity
@Table(name="STUDENTS")
class Student extends RepresentationModel<Student> {
    @Id
    @GeneratedValue
    @Column(name="ID")
    private Long id;
    @Column(name="NAME", length = 128)
    private String name;
    @Column(name="passport", length = 32)
    private String passport;

    public Student() {
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

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
}
