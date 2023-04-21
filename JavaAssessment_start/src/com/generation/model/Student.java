package com.generation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Student extends Person {
    public static final double PASS_MIN_GRADE = 3.0;

    private final HashMap<String, EnrolledCourse> enrolledCoursesHM = new HashMap<>();


    public Student(String studentId, String name, String email, Date birthDate) {
        super(studentId, name, email, birthDate);
    }

    public boolean enrollToCourse(Course course) {

        //TODO Check if student has already enrolled to the course, if not add the course to enrolledCourses hashmap

        // Used to enroll student object to course object
        // First checks if student has already enrolled in the course (referencing courseCode)
        // If not enrolled to course, adds new entry to enrolledCoursesHM using courseCode as key and a new instance of the EnrolledCourse object as the value
        // Used in StudentService to enroll to course

        String getCourseCode = course.getCourseCode();
        if (enrolledCoursesHM.containsKey(getCourseCode)) return false;

        enrolledCoursesHM.put(getCourseCode, new EnrolledCourse(course));
        return true;

        // Boolean indicates whether the enrollment was successful

        // Although this enrollToCourse method does not have a direct reference to the Student Class, it uses the enrolledCoursesHM (HashMap) in StudentService as a means of keeping track of the courses that a Student object is enrolled in.
    }

    public HashMap<String, EnrolledCourse> getEnrolledCoursesHM() {

        //TODO return a Hashmap of all the enrolledCourses

        // Returns a HashMap containing all the EnrolledCourse objects that a student is enrolled in
        // Used in 1) ShowSummary() method in StudentService as part of the for loop 2) Returns enrolled courses in enrolledCourseHM (HashMap) under StudentService 3) as part of for loop for calling gradeStudent() method in Main.java

        return enrolledCoursesHM;
    }

    public void gradeCourse(String courseCode, double grade) {

        //TODO set the grade for the enrolled Course

        // Takes courseCode and grade as input parameters and updates the new grade of enrolledCoursesHM (HashMap) via courseCode
        // Used in StudentService in gradeStudent() to set grade

            enrolledCoursesHM.get(courseCode).setGrade(grade);
    }

    public Course findCourseById(String courseId) {

        //TODO return a Course from the course Id

        // Takes in courseId as input parameter and returns related course object from enrolledCoursesHM (HashMap)
        // Used in findEnrolledCourses() method in StudentService to find course by id

        return enrolledCoursesHM.get(courseId);
    }

    public HashMap<String, EnrolledCourse> findPassedCourses() {

        //TODO Check the enrolled courses grade and compare to the passing grade

        // Uses for each loop with key value pairing to parse through enrolledCoursesHM (HashMap)
        // Looks for whose grades are equal or greater than what is defined in PASS_MIN_GRADE and updated passedCourses HashMap
        // Used in getPassedCourses() method in StudentService to retrieve passed courses

        HashMap<String, EnrolledCourse> passedCourses = new HashMap<>();
            enrolledCoursesHM.forEach((key, course) -> {
                if (course.getGrade() >= PASS_MIN_GRADE) {
                    passedCourses.put(key, course);
                }
            });
            return passedCourses;
    }

    public String toString() {
        return "Student {" + super.toString() + "}";
    }
}
