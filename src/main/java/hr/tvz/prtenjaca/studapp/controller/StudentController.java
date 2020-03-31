package hr.tvz.prtenjaca.studapp.controller;

import hr.tvz.prtenjaca.studapp.command.StudentCommand;
import hr.tvz.prtenjaca.studapp.dto.StudentDTO;
import hr.tvz.prtenjaca.studapp.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDTO> findAll() {
        return studentService.findAll();
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping(params = "JMBAG")
    public ResponseEntity<StudentDTO> findStudentByJMBAG(@Valid @RequestParam final String JMBAG) {
        return studentService.findStudentByJMBAG(JMBAG)
                .map(
                studentDTO -> ResponseEntity
                        .status(HttpStatus.FOUND)
                        .body(studentDTO)
                ).orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.NOT_FOUND)
                                .build()
                );
    }

    @PostMapping
    public ResponseEntity<StudentDTO> save(@Valid @RequestBody final StudentCommand command){
        return studentService.save(command)
                .map(
                        studentDTO -> ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body(studentDTO)
                )
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.CONFLICT)
                                .build()
                );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{JMBAG}")
    public void delete(@PathVariable String JMBAG){
        studentService.delete(JMBAG);
    }

}
