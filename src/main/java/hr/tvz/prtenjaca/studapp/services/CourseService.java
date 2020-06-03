package hr.tvz.prtenjaca.studapp.services;

import hr.tvz.prtenjaca.studapp.domain.Course;
import hr.tvz.prtenjaca.studapp.dto.CourseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

    List<CourseDTO> findAll();
    List<CourseDTO> findByStudentsJmbag(String jmbag);
}
