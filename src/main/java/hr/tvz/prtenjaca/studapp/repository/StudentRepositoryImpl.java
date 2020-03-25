package hr.tvz.prtenjaca.studapp.repository;

import hr.tvz.prtenjaca.studapp.domain.Student;
import hr.tvz.prtenjaca.studapp.services.StudentService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private final List<Student> MOCKED_STUDENTS = Arrays.asList(
            new Student("Ivo", "Ivić", "0256423323", LocalDate.now().minusYears(27), 120),
            new Student("Lucija", "Lucić", "0256423324", LocalDate.now().minusYears(25), 98)
    );

    @Override
    public List<Student> findAll() {
        return MOCKED_STUDENTS;
    }

    @Override
    public Optional<Student> findStudentByJMBAG(String JMBAG) {
        return MOCKED_STUDENTS.stream().filter(it -> Objects.equals(it.getJmbag(), JMBAG)).findAny();
    }
}
