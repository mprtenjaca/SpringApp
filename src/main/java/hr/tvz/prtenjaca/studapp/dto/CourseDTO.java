package hr.tvz.prtenjaca.studapp.dto;

public class CourseDTO {

    private String name;
    private int numberOfEcts;

    public CourseDTO(String name, int numberOfEcts) {
        this.name = name;
        this.numberOfEcts = numberOfEcts;
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

    public void setNumberOfEcts(int numberOfEcts) {
        this.numberOfEcts = numberOfEcts;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                ", name='" + name + '\'' +
                ", numberOfEcts=" + numberOfEcts +
                '}';
    }
}
