package hr.tvz.prtenjaca.studapp.services;

import hr.tvz.prtenjaca.studapp.domain.Course;
import hr.tvz.prtenjaca.studapp.dto.CourseDTO;
import hr.tvz.prtenjaca.studapp.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseDTO> findAll() {
        return courseRepository.findAll().stream().map(this::mapCourseToDTO).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> findByStudentsJmbag(String jmbag) {
        return courseRepository.findByStudentsJmbag(jmbag).stream().map(this::mapCourseToDTO).collect(Collectors.toList());
    }

    private CourseDTO mapCourseToDTO(final Course course){
        return new CourseDTO(course.getName(), course.getNumberOfEcts());
    }
}
