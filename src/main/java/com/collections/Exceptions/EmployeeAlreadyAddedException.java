package com.collections.Exceptions;

public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException() {
        super("В коллекции уже есть такой сотрудник");
    }
}
