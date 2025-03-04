package org.launchcode.techjobs_oo;

import java.util.Objects;

public abstract class JobProperty {
    int id;
    static int nextId = 1;
    String value;

    public JobProperty() {
        id = nextId;
        nextId++;
    }

    public JobProperty(String value) {
        this();
        this.value = value;
    }

    // Custom toString, equals, and hashCode methods:

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {  // Two objects are equal if they have the same id.
        if (this == o) return true;
        if (!(o instanceof JobProperty)) return false;
        JobProperty JobProperty = (JobProperty) o;
        return getId() == JobProperty.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // Getters and Setters:

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
