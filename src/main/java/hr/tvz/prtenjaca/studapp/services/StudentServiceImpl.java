package hr.tvz.prtenjaca.studapp.services;

import hr.tvz.prtenjaca.studapp.command.StudentCommand;
import hr.tvz.prtenjaca.studapp.domain.Student;
import hr.tvz.prtenjaca.studapp.dto.StudentDTO;
import hr.tvz.prtenjaca.studapp.repository.StudentRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public Optional<StudentDTO> findStudentByJMBAG(String jmbag) {
        return studentRepository.findStudentByJMBAG(jmbag).map(this::mapStudentToDTO);
    }

    @Override
    public Optional<StudentDTO> save(StudentCommand command) {
        return studentRepository.save(mapCommandToStudent(command)).map(this::mapStudentToDTO);
    }

    @Override
    @Secured({"ROLE_ADMIN", "ROLE_UPDATER"})
    public Optional<StudentDTO> update(String jmbag, StudentCommand command) {
        return studentRepository.update(jmbag, mapCommandToStudent(command)).map(this::mapStudentToDTO);
    }

    @Override
    public void delete(String jmbag) {
        studentRepository.delete(jmbag);
    }

    private StudentDTO mapStudentToDTO(final Student student) {
        return new StudentDTO(student.getFirstName(), student.getLastName(), student.getJmbag(), student.getNumberOfEcts(), shouldTuitionBePayed(student.getDateOfBirth()));
    }

    private Student mapCommandToStudent(StudentCommand command) {
        Student student = new Student();
        student.setFirstName(command.getFirstName());
        student.setLastName(command.getLastName());
        student.setJmbag(command.getJmbag());
        student.setDateOfBirth(command.getDateOfBirth());
        student.setNumberOfEcts(command.getNumberOfEcts());
        return student;
    }

    private boolean shouldTuitionBePayed(LocalDate dateOfBirth){
        return dateOfBirth.plusYears(YEARS_AFTER_WHICH_TUITION_SHOULD_BE_PAYED).isBefore(LocalDate.now());
    }

}
