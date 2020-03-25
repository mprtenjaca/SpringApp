package hr.tvz.prtenjaca.studapp.domain;

import java.time.LocalDate;

public class Student {
    private String firstName;
    private String lastName;
    private String jmbag;
    private LocalDate birthday;
    private Integer ects;

    public Student(String firstName, String lastName,  String jmbag, LocalDate birthday, Integer ects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jmbag = jmbag;
        this.birthday = birthday;
        this.ects = ects;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getJmbag() {
        return jmbag;
    }

    public void setJmbag(String jmbag) {
        this.jmbag = jmbag;
    }

    public Integer getEcts() {
        return ects;
    }

    public void setEcts(Integer ects) {
        this.ects = ects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", jmbag='" + jmbag + '\'' +
                ", ects=" + ects +
                '}';
    }
}
