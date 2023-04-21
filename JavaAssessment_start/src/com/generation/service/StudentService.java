package com.generation.service;

import com.generation.model.Course;
import com.generation.model.EnrolledCourse;
import com.generation.model.Student;

import java.util.HashMap;

public class StudentService {
    private final HashMap<String, Student> studentsHM = new HashMap<>();

    public void registerStudent(Student student) {

        //TODO Add new student to the students hashmap

        // Takes the passed in Student object parameter and adds it to the HashMap
        // This method is used in Main.java to register student

        this.studentsHM.put(student.getStudentId(), student);

    }

    public Student findStudent(String studentId) {

        //TODO Find the student from the Hashmap with the student id

        // Takes studentID as the input parameter and returns the related Student object from StudentsHM (HashMap)
        // This method is used in Main.java for three usa cases: 1) to find student to enroll them to a course 2) to find the student from studentsHM (HashMap) 3) to find the student to display their passed course(s)

        if (this.studentsHM.containsKey(studentId)) {
            return this.studentsHM.get(studentId);
        }
        return null;
    }

    public void enrollToCourse(String studentId, Course course) {

        //TODO check if students hashmap contains the studentsId, if not enroll student to the course

        // Takes studentId and a Course object as input parameters and checks if studentsHM (HashMap) contains the studentId
        // If it does, it retrieves the related Student object and enrolls the student in the Course object
        // This method is used in Main.java to enroll student to course

        Student student = studentsHM.get(studentId);

        if (student != null) {
            student.enrollToCourse(course);
        }
    }

    public void showSummary() {

        //TODO Loop through students hashmap and print out students' details including the enrolled courses

        // This method uses a for-each loop to look through all the Student object instances in studentsHM (HashMap) and prints out each student's details including their enrolled courses
        // Used in Main.java to show the summary of courses

        System.out.println("Student Summary:");
        for (Student student : studentsHM.values()) {
            System.out.println(student);
            System.out.println("Enrolled Courses:");
            for (EnrolledCourse course : student.getEnrolledCoursesHM().values()) {
                System.out.println(course);
            }
        }
    }

    public HashMap<String, EnrolledCourse> enrolledCoursesHM(Student student) {

        //TODO return a HashMap of all the enrolledCourses

        // Takes a student object as input parameter and returns a HashMap containing all the enrolled course objects that the student is enrolled in
        // Referenced in gradeStudent() method in Main.java to find enrolled courses

        return student.getEnrolledCoursesHM();
    }

    public Course findEnrolledCourse(Student student, String courseId) {

        //TODO return the course enrolled by the student from the course Id

        // Takes a student object and courseID as input parameters and returns the related course object from the enrolledCourseHM (HashMap) of the student
        // Referenced in Student Class

        return student.findCourseById(courseId);
    }

    public void gradeStudent(Student student, Course course, double grade) {
        student.gradeCourse(course.getCourseCode(), grade);
    }


    public HashMap<String, EnrolledCourse> getPassedCourses(Student student) {
        return student.findPassedCourses();
    }
}
