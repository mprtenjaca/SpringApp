package hr.tvz.prtenjaca.studapp.services;

import hr.tvz.prtenjaca.studapp.domain.Student;
import hr.tvz.prtenjaca.studapp.dto.StudentDTO;
import hr.tvz.prtenjaca.studapp.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.LocalDate.now;

@Service
public class StudentServiceImpl implements StudentService {

    private static final int YEARS_AFTER_WHICH_TUITION_SHOULD_BE_PAYED = 26;

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream().map(this::mapStudentToDTO).collect(Collectors.toList());

    }

    @Override
    public StudentDTO findStudentByJMBAG(String JMBAG) {
        return studentRepository.findStudentByJMBAG(JMBAG).map(this::mapStudentToDTO).orElse(null);
    }

    private StudentDTO mapStudentToDTO(final Student student){
        return new StudentDTO(student.getJmbag(), student.getEcts(), shouldTuitionBePayed(student.getBirthday()));
    }


    private boolean shouldTuitionBePayed(LocalDate dateOfBirth){
        return dateOfBirth.plusYears(YEARS_AFTER_WHICH_TUITION_SHOULD_BE_PAYED).isBefore(LocalDate.now());
    }

}
