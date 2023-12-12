package com.collections.Exceptions;

public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException() {
        super("Коллекции уже есть такой сотрудник");
    }
}
