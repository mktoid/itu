package io.github.mktoid.itu;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
class StudentController {

    private final StudentRepository repository;

    StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/students")
    List<Student> all() {
        return repository.findAll();
    }

    @PostMapping("/students")
    Student newStudent(@RequestParam String name, @RequestParam String passport) {

        List<Student> studentsWithGivenPassport = repository.findByPassport(passport);

        Student newStudent = new Student();
        newStudent.setName(name.trim());
        newStudent.setPassport(passport.trim());

        if (studentsWithGivenPassport.size() == 0) {
            return repository.save(newStudent);
        } else {
            throw new PassportNotUniqueException(passport);
        }
    }

    @GetMapping("/students/{id}")
    public HttpEntity<Student> one(@PathVariable Long id) {
        Student student =  repository.findById(id)
                .orElseThrow(()-> new StudentNotFoundException(id));

        student.add(linkTo(methodOn(StudentController.class).one(id)).withSelfRel());
        student.add(linkTo(methodOn(StudentController.class).all()).withRel("student"));
        return new ResponseEntity<>(student, HttpStatus.OK);

    }

    @PutMapping("/students/{id}")
    Student replaceStudent(@RequestBody Student newStudent, @PathVariable Long id) {
        return repository.findById(id)
                .map(student -> {
                    student.setName(newStudent.getName());
                    student.setPassport(newStudent.getPassport());
                    return repository.save(student);
                })
                .orElseGet(() -> {
                    newStudent.setId(id);
                    return repository.save(newStudent);
                });
    }

    @DeleteMapping("/students/{id}")
    void deleteStudent(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
