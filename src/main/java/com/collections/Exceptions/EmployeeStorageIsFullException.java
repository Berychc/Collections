package com.collections.Exceptions;

public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException() {
        super("Превышен лимит количества сотрудников в фирме!");
    }
}
