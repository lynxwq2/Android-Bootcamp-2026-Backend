package ru.sicampus.bootcamp2026.exception;

public class AuthorityNotFound extends RuntimeException {
    public AuthorityNotFound(String message) {
        super(message);
    }
}
