package hr.tvz.prtenjaca.studapp.services;

import hr.tvz.prtenjaca.studapp.dto.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {

    List<StudentDTO> findAll();

    StudentDTO findStudentByJMBAG(String JMBAG);

}
