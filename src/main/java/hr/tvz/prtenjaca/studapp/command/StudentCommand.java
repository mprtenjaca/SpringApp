package hr.tvz.prtenjaca.studapp.command;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class StudentCommand {

    @NotBlank(message = "First name must not be empty")
    private String firstName;

    @NotBlank(message = "Last name must not be empty")
    private String lastName;

    @NotBlank(message = "JMBAG name must not be empty")
    @Pattern(message = "JMBAG must have 10 digits", regexp = "[\\d]{10}")
    private String jmbag;


    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

//    public StudentCommand(String firstName, String lastName,  @NotBlank(message = "JMBAG must not be empty") @Pattern(message = "JMBAG must have 10 digits", regexp = "[\\d]{10}") String jmbag, Integer numberOfEcts) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.jmbag = jmbag;
//        this.numberOfEcts = numberOfEcts;
//    }

    @NotNull(message = "Number of ECTS points must be entered")
    @PositiveOrZero(message = "Number of ECTS must be entered as a positive integer")
    @Max(message = "Number of ECTS can not be higher than 480", value = 480)
    private int numberOfEcts;


    public StudentCommand(@NotBlank(message = "First name must not be empty") String firstName, @NotBlank(message = "Last name must not be empty") String lastName, @NotBlank(message = "JMBAG name must not be empty") @Pattern(message = "JMBAG must have 10 digits", regexp = "[\\d]{10}") String jmbag, @NotNull(message = "Number of ECTS points must be entered") @PositiveOrZero(message = "Number of ECTS must be entered as a positive integer") @Max(message = "Number of ECTS can not be higher than 480", value = 480) int numberOfEcts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jmbag = jmbag;
        this.numberOfEcts = numberOfEcts;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getJmbag() {
        return jmbag;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getNumberOfEcts() {
        return numberOfEcts;
    }

    public void setJmbag(String jmbag) {
        this.jmbag = jmbag;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setNumberOfEcts(int numberOfEcts) {
        this.numberOfEcts = numberOfEcts;
    }
}
