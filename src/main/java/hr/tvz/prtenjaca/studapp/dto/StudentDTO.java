package hr.tvz.prtenjaca.studapp.dto;

public class StudentDTO {

    private String firstName;
    private String lastName;
    private String jmbag;
    private Integer numberOfECTS;
    private boolean tuitionShouldBePaid = false;

    public StudentDTO(String firstName, String lastName, String jmbag, Integer numberOfECTS, boolean tuitionShouldBePaid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jmbag = jmbag;
        this.numberOfECTS = numberOfECTS;
        this.tuitionShouldBePaid = tuitionShouldBePaid;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
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
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", jmbag='" + jmbag + '\'' +
                ", numberOfECTS=" + numberOfECTS +
                ", tuitionShouldBePaid=" + tuitionShouldBePaid +
                '}';
    }
}
