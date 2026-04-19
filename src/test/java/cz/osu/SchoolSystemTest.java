package cz.osu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SchoolSystemTest {

    @Test
    void shouldCreateGradeForStudentInCourse() {
        SchoolSystem schoolSystem = new SchoolSystem();
        Student student = new Student("A12345");
        Course course = new Course("KIP/JAVA", "Java Basics");
        Lecturer lecturer = new Lecturer("Ing. Novák");

        schoolSystem.addStudent(student);
        schoolSystem.addCourse(course);

        Grade grade = schoolSystem.addGrade(student, course, 1, lecturer);

        assertEquals(1, grade.getValue());
        assertEquals(student, grade.getStudent());
        assertEquals(course, grade.getCourse());
        assertEquals(lecturer, grade.getLecturer());
        assertNotNull(grade.getInsertedAt());
        assertTrue(schoolSystem.getGrade(student, course).isPresent());
    }

    @Test
    void shouldNotAllowDuplicateGradeForSameStudentAndCourse() {
        SchoolSystem schoolSystem = new SchoolSystem();
        Student student = new Student("A12345");
        Course course = new Course("KIP/JAVA", "Java Basics");
        Lecturer lecturer = new Lecturer("Ing. Novák");

        schoolSystem.addStudent(student);
        schoolSystem.addCourse(course);
        schoolSystem.addGrade(student, course, 2, lecturer);

        assertThrows(DuplicateGradeException.class,
                () -> schoolSystem.addGrade(student, course, 3, lecturer));
    }
}
