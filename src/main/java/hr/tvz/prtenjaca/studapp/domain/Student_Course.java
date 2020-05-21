package hr.tvz.prtenjaca.studapp.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigInteger;


public class Student_Course implements Serializable {

    private Long student;

    private Long course;

    public Student_Course() { }

    public Long getStudent() {
        return student;
    }

    public void setStudent(Long student) {
        this.student = student;
    }

    public Long getCourse() {
        return course;
    }

    public void setCourse(Long course) {
        this.course = course;
    }
}
