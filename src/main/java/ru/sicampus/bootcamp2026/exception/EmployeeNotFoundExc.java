package ru.sicampus.bootcamp2026.exception;

public class EmployeeNotFoundExc extends RuntimeException {
    public EmployeeNotFoundExc(String message) {
        super(message);
    }
}
