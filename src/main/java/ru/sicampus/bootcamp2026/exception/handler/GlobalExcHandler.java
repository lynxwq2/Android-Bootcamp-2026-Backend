package ru.sicampus.bootcamp2026.exception.handler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.sicampus.bootcamp2026.exception.EmployeeAlreadyExExc;
import ru.sicampus.bootcamp2026.exception.EmployeeNotFoundExc;
import ru.sicampus.bootcamp2026.exception.PlaceNotFoundExc;

@ControllerAdvice
public class GlobalExcHandler {

    @ExceptionHandler(PlaceNotFoundExc.class)
    public ResponseEntity<String> handlePlaceNotFoundExc(PlaceNotFoundExc e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmployeeNotFoundExc.class)
    public ResponseEntity<String> handleEmployeeNotFoundExc(EmployeeNotFoundExc e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmployeeAlreadyExExc.class)
    public ResponseEntity<String> handleEmployeeAlreadyExExc(EmployeeNotFoundExc e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }
}
