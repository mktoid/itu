package io.github.mktoid.itu;

class StudentNotFoundException extends RuntimeException {
    StudentNotFoundException(Long id) {
        super("Error: Could not find student " + id);
    }
}
