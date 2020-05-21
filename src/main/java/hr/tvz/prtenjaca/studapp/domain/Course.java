package hr.tvz.prtenjaca.studapp.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int numberOfEcts;

    @ManyToMany(targetEntity = Student.class)
    @JoinTable(name = "student_course",
            joinColumns = { @JoinColumn(name = "student_id") },
            inverseJoinColumns = { @JoinColumn(name = "course_id") })
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Course() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfEcts() {
        return numberOfEcts;
    }

    public void setNumberOfEcts(int numberOfECTS) {
        this.numberOfEcts = numberOfEcts;
    }
}
