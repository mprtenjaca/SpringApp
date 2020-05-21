package hr.tvz.prtenjaca.studapp.repository;
import hr.tvz.prtenjaca.studapp.domain.Course;
import hr.tvz.prtenjaca.studapp.dto.CourseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findAll();
    List<Course> findByStudentsJmbag(String jmbag);

    List<Course> findByNumberOfEcts(int numberOfEcts);

}
