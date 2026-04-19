package cz.osu;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class SchoolSystem {

    private Set<Student> students = new HashSet<>();
    private Set<Course> courses = new HashSet<>();
    private final Map<Student, Map<Course, Grade>> grades = new HashMap<>();

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public Grade addGrade(Student student, Course course, int value, Lecturer lecturer) {
        Map<Course, Grade> studentGrades = grades.computeIfAbsent(student, s -> new HashMap<>());

        if (studentGrades.containsKey(course)) {
            throw new DuplicateGradeException("Student already has a grade in this course.");
        }

        Grade grade = new Grade(student, course, value, LocalDateTime.now(), lecturer);
        studentGrades.put(course, grade);
        return grade;
    }

    public Optional<Grade> getGrade(Student student, Course course) {
        return Optional.ofNullable(
                grades.getOrDefault(student, Map.of()).get(course)
        );
    }
}
