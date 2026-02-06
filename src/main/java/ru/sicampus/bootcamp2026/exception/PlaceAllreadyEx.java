package ru.sicampus.bootcamp2026.exception;

public class PlaceAllreadyEx extends RuntimeException {
    public PlaceAllreadyEx(String message) {
        super(message);
    }
}
