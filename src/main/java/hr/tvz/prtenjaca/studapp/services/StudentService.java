package hr.tvz.prtenjaca.studapp.services;

import hr.tvz.prtenjaca.studapp.command.StudentCommand;
import hr.tvz.prtenjaca.studapp.dto.StudentDTO;

import java.util.List;
import java.util.Optional;


public interface StudentService {

    List<StudentDTO> findAll();

    Optional<StudentDTO> findStudentByJMBAG(String JMBAG);

    Optional<StudentDTO> save(StudentCommand command);

    void delete(String JMBAG);

}
