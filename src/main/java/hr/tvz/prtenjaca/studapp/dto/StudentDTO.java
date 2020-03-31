package hr.tvz.prtenjaca.studapp.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class StudentDTO {

    private String jmbag;

    private Integer numberOfECTS;
    private boolean tuitionShouldBePaid = false;

    public StudentDTO(String jmbag, Integer numberOfECTS, boolean tuitionShouldBePaid) {
        this.jmbag = jmbag;
        this.numberOfECTS = numberOfECTS;
        this.tuitionShouldBePaid = tuitionShouldBePaid;
    }

    public String getJMBAG() {
        return jmbag;
    }
    public Integer getNumberOfECTS() {
        return numberOfECTS;
    }
    public boolean isTuitionShouldBePaid() {
        return tuitionShouldBePaid;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "jmbag='" + jmbag + '\'' +
                ", ects=" + numberOfECTS +
                ", payingTuitionFees=" + tuitionShouldBePaid +
                '}';
    }
}
