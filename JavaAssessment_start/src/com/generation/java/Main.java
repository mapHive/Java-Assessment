package com.generation.java;

import com.generation.model.Course;
import com.generation.model.EnrolledCourse;
import com.generation.model.Student;
import com.generation.service.CourseService;
import com.generation.service.StudentService;
import com.generation.utils.PrinterHelper;

import java.text.ParseException;
import java.util.*;

public class Main {

    public static void main(String[] args)
            throws ParseException {
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            PrinterHelper.showMainMenu();
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    registerStudent(studentService, scanner);
                    break;
                case 2:
                    findStudent(studentService, scanner);
                    break;
                case 3:
                    gradeStudent(studentService, scanner);
                    break;
                case 4:
                    enrollStudentToCourse(studentService, courseService, scanner);
                    break;
                case 5:
                    showStudentsSummary(studentService, scanner);
                    break;
                case 6:
                    showCoursesSummary(courseService, scanner);
                    break;
                case 7:
                    showPassedCourses(studentService, scanner);
                    break;
            }
        }
        while (option != 8);
    }

    private static void enrollStudentToCourse(StudentService studentService, CourseService courseService,
                                              Scanner scanner) {
        System.out.println("Insert student ID");
        String studentId = scanner.next();
        Student student = studentService.findStudent(studentId);
        if (student == null) {
            System.out.println("Invalid Student ID");
            return;
        }
        System.out.println(student);
        System.out.println("Insert course ID");
        String courseId = scanner.next();
        Course course = courseService.getCourse(courseId);
        if (course == null) {
            System.out.println("Invalid Course ID");
            return;
        }
        System.out.println(course);
        studentService.enrollToCourse(studentId, course);
        System.out.println("Student with ID: " + studentId + " enrolled successfully to " + courseId);

    }

    private static void showCoursesSummary(CourseService courseService, Scanner scanner) {
        courseService.showSummary();
    }

    private static void showStudentsSummary(StudentService studentService, Scanner scanner) {
        studentService.showSummary();
    }

    private static void gradeStudent(StudentService studentService, Scanner scanner) {
        Student student = getStudentInformation(studentService, scanner);
        System.out.println("Enrolled course:");

        // Student object retrieved using getStudentInformation() method - utility method within Main.java used to retrieve a Student object by studentID

        //TODO Loop through the student enrolled courses, and use the scanner object to get the course ID to insert
        // the course grade

        // Uses the gradeStudent() method in StudentService
        // Uses a for loop to iterate through the getEnrolledCourse HM (HashMap) in StudentService and prints out the object values, then prompts input from user to enter grade based on courseCode
        // Grade is saved from user input by calling gradeStudent() method from StudentService

        for (EnrolledCourse course : student.getEnrolledCoursesHM().values()) {
            System.out.println(course);
            System.out.println("Enter grade for course " + course.getCourseCode() + ":");
            double grade = scanner.nextDouble();
            studentService.gradeStudent(student, course, grade);
        }
    }

    private static Student getStudentInformation(StudentService studentService, Scanner scanner) {
        System.out.println("Enter student ID: ");
        String studentId = scanner.next();
        Student student = studentService.findStudent(studentId);
        if (student == null) {
            System.out.println("Student not found");
        }
        return student;
    }

    private static void findStudent(StudentService studentService, Scanner scanner) {
        Student student = getStudentInformation(studentService, scanner);
        if (student != null) {
            System.out.println("Student Found: ");
            System.out.println(student);
        }
    }

    private static void registerStudent(StudentService studentService, Scanner scanner) throws ParseException {
        Student student = PrinterHelper.createStudentMenu(scanner);
        studentService.registerStudent(student);
    }

    private static void showPassedCourses(StudentService studentService, Scanner scanner) {

        //TODO Loop through the student enrolled courses, and show all the passed courses

        // Uses findStudent() method from StudentService to retrieve student object
        // If student not found, message is printed and method returned
        // If found, getPassedCourses() method from StudentService is called to return HashMap containing all passed courses
        // If passed courses exist, iterates through HashMap and prints values of each passed course

        System.out.println("Enter student ID: ");
        String studentId = scanner.next();
        Student student = studentService.findStudent(studentId);
        if (student == null) {
            System.out.println("Student not found");
            return;
        }
        System.out.println("Passed courses for student " + studentId + ":");
        HashMap<String, EnrolledCourse> passedCourses = studentService.getPassedCourses(student);
        if (passedCourses.isEmpty()) {
            System.out.println("No passed courses found for this student.");
        } else {
            for (EnrolledCourse course : passedCourses.values()) {
                System.out.println(course);
            }
        }
    }
}
