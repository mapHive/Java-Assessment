package com.generation.model;

public class Course {
    private final String courseCode;
    private final String courseName;
    private final int credits;
    private final Module module;

    public Course(String courseCode, String courseName, int credits, Module module) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
        this.module = module;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    public Module getModule() {
        return module;
    }

    public String toString() {
        return "Course{" + "code='" + courseCode + '\'' + ", name='" + courseName + '\'' + ", credits=" + credits + ", module="
                + module + '}';
    }
}
