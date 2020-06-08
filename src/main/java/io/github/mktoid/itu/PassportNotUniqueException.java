package io.github.mktoid.itu;

class PassportNotUniqueException extends RuntimeException {
    PassportNotUniqueException(String passport) {
        super("\uD83D\uDC6C Passport " + passport + " is already used by another student");
    }
}

