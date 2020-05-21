package hr.tvz.prtenjaca.studapp.services;

import hr.tvz.prtenjaca.studapp.command.StudentCommand;
import hr.tvz.prtenjaca.studapp.domain.Student;
import hr.tvz.prtenjaca.studapp.dto.StudentDTO;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<StudentDTO> findAll();
    Optional<StudentDTO> findStudentByJMBAG(String jmbag);
    Optional<StudentDTO> save(StudentCommand command);
    Optional<StudentDTO> update(String jmbag, StudentCommand command);
    void delete(String jmbag);

}
