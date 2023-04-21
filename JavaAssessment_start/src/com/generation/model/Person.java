package com.generation.model;

import java.util.Date;

abstract public class Person {
    private final String studentId;
    private final String name;
    private final String email;
    private final Date birthDate;

    protected Person(String studentId, String name, String email, Date birthDate) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return studentId + '\'' + ", name='" + name + '\'' + ", email='" + email + '\'' + ", birthDate=" + birthDate;
    }
}
