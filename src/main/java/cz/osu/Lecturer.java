package cz.osu;

import java.util.Objects;

public class Lecturer {

    private String name;

    public Lecturer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Lecturer lecturer)) {
            return false;
        }
        return Objects.equals(name, lecturer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
