package com.collections.Employees;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Сотрудник {" + firstName + "\"" + lastName + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
