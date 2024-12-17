package com.aston.afspapp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Student extends BaseEntity implements Serializable, Comparable<Student> {

    private Integer groupNumber;
    private BigDecimal averageScore;
    private Integer gradeBookNumber;

    public Student(Integer groupNumber, BigDecimal averageScore, Integer gradeBookNumber) {
        this.groupNumber = groupNumber;
        this.averageScore = averageScore;
        this.gradeBookNumber = gradeBookNumber;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(Integer groupNumber) {
        this.groupNumber = groupNumber;
    }

    public BigDecimal getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(BigDecimal averageScore) {
        this.averageScore = averageScore;
    }

    public int getGradeBookNumber() {
        return gradeBookNumber;
    }

    public void setGradeBookNumber(Integer gradeBookNumber) {
        this.gradeBookNumber = gradeBookNumber;
    }

    @Override
    public int compareTo(Student student) {
        if (student == null) {
            return 1;
        }
        int result = this.groupNumber.compareTo(student.groupNumber);
        if (result != 0) {
            return result;
        }
        result = this.averageScore.compareTo(student.averageScore);
        if (result != 0) {
            return result;
        }
        return this.gradeBookNumber.compareTo(student.gradeBookNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(getGroupNumber(), student.getGroupNumber())
                && Objects.equals(getAverageScore(), student.getAverageScore())
                && Objects.equals(getGradeBookNumber(), student.getGradeBookNumber());
    }

    @Override
    public int hashCode() {
        int total = 31;
        total = total * 31 + getGroupNumber();
        total = total * 31 + getAverageScore().intValue();
        total = total * 31 + getGradeBookNumber();
        return total;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Student{groupNumber=").append(getGroupNumber())
                .append(", averageScore=").append(getAverageScore())
                .append(", gradebookNumber=").append(getGradeBookNumber())
                .append('}')
                .toString();
    }

    public static class Builder {
        private int groupNumber;
        private BigDecimal averageScore;
        private int gradebookNumber;

        public Builder setGroupNumber(int groupNumber) {
            this.groupNumber = groupNumber;
            return this;
        }

        public Builder setAverageScore(BigDecimal averageScore) {
            this.averageScore = averageScore;
            return this;
        }

        public Builder setGradebookNumber(int gradebookNumber) {
            this.gradebookNumber = gradebookNumber;
            return this;
        }

        public Student build() {
            return new Student(groupNumber, averageScore, gradebookNumber);
        }
    }
}
