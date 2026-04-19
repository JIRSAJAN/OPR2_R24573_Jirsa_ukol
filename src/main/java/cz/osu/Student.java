package cz.osu;

import java.util.Objects;

public class Student {

    private final String studyNumber;

    public Student(String studyNumber) {
        this.studyNumber = studyNumber;
    }

    public String getStudyNumber() {
        return studyNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student student)) {
            return false;
        }
        return Objects.equals(studyNumber, student.studyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studyNumber);
    }
}
