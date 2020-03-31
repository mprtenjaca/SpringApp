package hr.tvz.prtenjaca.studapp.domain;

import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Optional;

public class Student {
    private String firstName;
    private String lastName;
    private String jmbag;
    private LocalDate dateOfBirth;
    private Integer numberOfECTS;

    public Student(String firstName, String lastName,  String jmbag, LocalDate dateOfBirth, Integer numberOfECTS) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jmbag = jmbag;
        this.dateOfBirth = dateOfBirth;
        this.numberOfECTS = numberOfECTS;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getJmbag() {
        return jmbag;
    }

    public void setJmbag(String jmbag) {
        this.jmbag = jmbag;
    }

    public Integer getNumberOfECTS() {
        return numberOfECTS;
    }

    public void setNumberOfECTS(Integer ects) {
        this.numberOfECTS = numberOfECTS;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + dateOfBirth +
                ", jmbag='" + jmbag + '\'' +
                ", ects=" + numberOfECTS +
                '}';
    }
}
