package hr.tvz.prtenjaca.studapp.dto;

public class StudentDTO {
    private String jmbag;
    public Integer ects;

    private boolean tuitionShouldBePaid = false;

    public StudentDTO(String jmbag, Integer ects, boolean tuitionShouldBePaid) {
        this.jmbag = jmbag;
        this.ects = ects;
        this.tuitionShouldBePaid = tuitionShouldBePaid;
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

    public boolean tuitionShouldBePaid() {
        return tuitionShouldBePaid;
    }

    public void setTuitionShouldBePaid(boolean tuitionShouldBePaid) {
        this.tuitionShouldBePaid = tuitionShouldBePaid;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "jmbag='" + jmbag + '\'' +
                ", ects=" + ects +
                ", payingTuitionFees=" + tuitionShouldBePaid +
                '}';
    }
}
