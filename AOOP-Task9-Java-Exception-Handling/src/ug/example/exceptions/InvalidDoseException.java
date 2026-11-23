package ug.example.exceptions;

// I added this custom exception that extends "Exception" (making it a CHECKED exception:
// This forces any code calling something that throws this to handle or declare it
public class InvalidDoseException extends Exception {
    public InvalidDoseException(String message) {
        super(message);

    }
}