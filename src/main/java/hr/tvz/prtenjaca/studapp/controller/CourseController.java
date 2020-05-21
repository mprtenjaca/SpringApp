package hr.tvz.prtenjaca.studapp.controller;

import hr.tvz.prtenjaca.studapp.domain.Course;
import hr.tvz.prtenjaca.studapp.dto.CourseDTO;
import hr.tvz.prtenjaca.studapp.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping(value = "", produces = "application/json")
    private List<CourseDTO> findAll(){
        return courseService.findAll();
    }

    @GetMapping(value = "/{jmbag}", produces = "application/json")
    public List<CourseDTO> findByStudentsJmbag(@PathVariable String jmbag) {
        return courseService.findByStudentsJmbag(jmbag);
    }

    @GetMapping(value = "/ects/{ects}", produces = "application/json")
    public List<CourseDTO> findByNumberOfEcts(@PathVariable int ects){
        return courseService.findByNumberOfEcts(ects);
    }

}
