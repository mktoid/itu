package io.github.mktoid.itu;

class StudentNotFoundException extends RuntimeException {
    StudentNotFoundException(Long id) {
        super("\uD83D\uDE31 Could not find student " + id);
    }
}
