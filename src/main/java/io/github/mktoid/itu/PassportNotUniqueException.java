package io.github.mktoid.itu;

class PassportNotUniqueException extends RuntimeException {
    PassportNotUniqueException(String passport) {
        super("Error: passport " + passport + " is already used by another student");
    }
}

