package io.github.mktoid.itu;

import org.hibernate.annotations.CollectionId;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;

@Entity
@Table(name="STUDENTS")
class Student extends RepresentationModel<Student> {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
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
