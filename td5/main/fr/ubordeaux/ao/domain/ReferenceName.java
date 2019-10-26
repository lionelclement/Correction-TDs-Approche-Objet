package fr.ubordeaux.ao.domain;

import java.util.regex.*;

public class ReferenceName {
    private String value;

    public ReferenceName(String value) {
        Pattern pattern = Pattern.compile("^[a-zA-Z][a-zA-Z\\s]+$");
        if (!pattern.matcher(value).matches()) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof ReferenceName) {
            ReferenceName otherAW = (ReferenceName) other;
            return otherAW.value == value;
        } else {
            return false;
        }
    }
}