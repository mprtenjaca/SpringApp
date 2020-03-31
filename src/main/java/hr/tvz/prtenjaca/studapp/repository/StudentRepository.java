package hr.tvz.prtenjaca.studapp.repository;

import hr.tvz.prtenjaca.studapp.command.StudentCommand;
import hr.tvz.prtenjaca.studapp.domain.Student;

import java.util.List;
import java.util.Optional;


public interface StudentRepository {
    List<Student> findAll();

    Optional<Student> findStudentByJMBAG(String JMBAG);

    Optional<Student> save(StudentCommand command);

    void delete(String JMBAG);
}
