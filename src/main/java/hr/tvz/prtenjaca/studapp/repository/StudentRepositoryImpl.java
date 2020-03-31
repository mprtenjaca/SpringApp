package hr.tvz.prtenjaca.studapp.repository;

import hr.tvz.prtenjaca.studapp.command.StudentCommand;
import hr.tvz.prtenjaca.studapp.domain.Student;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private List<Student> MOCKED_STUDENTS = new ArrayList<>(Arrays.asList(
            new Student("Ivo", "Ivić", "0256423323", LocalDate.now().minusYears(27), 120),
            new Student("Lucija", "Lucić", "0256423324", LocalDate.now().minusYears(25), 98)
    ));

    @Override
    public List<Student> findAll() {
        return MOCKED_STUDENTS;
    }

    @Override
    public Optional<Student> findStudentByJMBAG(String JMBAG) {
        return MOCKED_STUDENTS.stream().filter(it -> Objects.equals(it.getJmbag(), JMBAG)).findAny();
    }

    @Override
    public Optional<Student> save(StudentCommand command) {

        Student student = new Student(command.getFirstName(), command.getLastName(), command.getJmbag(), command.getDateOfBirth(), command.getNumberOfECTS());
        Optional<Student> optionalStudent;

        if (ifContains(command)) {
            optionalStudent = Optional.empty();
        } else {
            MOCKED_STUDENTS.add(student);
            optionalStudent = Optional.of(student);
        }

        return optionalStudent;
    }

    @Override
    public void delete(String JMBAG) {
        MOCKED_STUDENTS.removeIf(it -> Objects.equals(it.getJmbag(), JMBAG));
    }

    private boolean ifContains(StudentCommand command) {
        return MOCKED_STUDENTS.stream().distinct().anyMatch(it -> Objects.equals(it.getJmbag(), command.getJmbag()));
    }
}
