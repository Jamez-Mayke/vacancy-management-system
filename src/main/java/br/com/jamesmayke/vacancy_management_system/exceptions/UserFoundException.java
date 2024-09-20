package br.com.jamesmayke.vacancy_management_system.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException() {
        super("User Already exists!");
    }
}
