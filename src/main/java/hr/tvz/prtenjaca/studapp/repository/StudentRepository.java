package hr.tvz.prtenjaca.studapp.repository;

import hr.tvz.prtenjaca.studapp.domain.Student;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface StudentRepository {
    List<Student> findAll();

    Optional<Student> findStudentByJMBAG(String JMBAG);
}
