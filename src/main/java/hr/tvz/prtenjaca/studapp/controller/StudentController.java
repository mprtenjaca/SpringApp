package hr.tvz.prtenjaca.studapp.controller;

import hr.tvz.prtenjaca.studapp.dto.StudentDTO;
import hr.tvz.prtenjaca.studapp.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(params = "JMBAG")
    public StudentDTO findStudentByJMBAG(@RequestParam final String JMBAG) {
        return studentService.findStudentByJMBAG(JMBAG);
    }

}
