package hr.tvz.prtenjaca.studapp.services;

import hr.tvz.prtenjaca.studapp.command.StudentCommand;
import hr.tvz.prtenjaca.studapp.domain.Student;
import hr.tvz.prtenjaca.studapp.dto.StudentDTO;
import hr.tvz.prtenjaca.studapp.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
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
    public Optional<StudentDTO> findStudentByJMBAG(String JMBAG) {
        return studentRepository.findStudentByJMBAG(JMBAG).map(this::mapStudentToDTO);
    }

    @Override
    public Optional<StudentDTO> save(StudentCommand command) {
        return studentRepository.save(command).map(this::mapStudentToDTO);
    }

    @Override
    public void delete(String JMBAG) {
        studentRepository.delete(JMBAG);
    }

    private StudentDTO mapStudentToDTO(final Student student){
        return new StudentDTO(student.getJmbag(), student.getNumberOfECTS(), shouldTuitionBePayed(student.getDateOfBirth()));
    }


    private boolean shouldTuitionBePayed(LocalDate dateOfBirth){
        return dateOfBirth.plusYears(YEARS_AFTER_WHICH_TUITION_SHOULD_BE_PAYED).isBefore(LocalDate.now());
    }

}
