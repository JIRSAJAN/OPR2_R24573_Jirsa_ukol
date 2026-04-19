package cz.osu;

import java.time.LocalDateTime;

public class Grade {

    private final Student student;
    private final Course course;
    private final int value;
    private final LocalDateTime insertedAt;
    private final Lecturer lecturer;

    public Grade(Student student, Course course, int value, LocalDateTime insertedAt, Lecturer lecturer) {
        this.student = student;
        this.course = course;
        this.value = value;
        this.insertedAt = insertedAt;
        this.lecturer = lecturer;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public int getValue() {
        return value;
    }

    public LocalDateTime getInsertedAt() {
        return insertedAt;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }
}
