package ug.example.exceptions;

public class InvalidDoseException extends Exception {
    public InvalidDoseException(String message) {
        super(message);
    }
}