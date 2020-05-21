package hr.tvz.prtenjaca.studapp.repository;

import hr.tvz.prtenjaca.studapp.domain.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class JdbcStudentRepository implements StudentRepository{

    private JdbcTemplate jdbc;
    private SimpleJdbcInsert studentInsert;

    public JdbcStudentRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
        this.studentInsert = new SimpleJdbcInsert(jdbc).withTableName("Student").usingGeneratedKeyColumns("id");
    }

    @Override
    public List<Student> findAll() {
        return jdbc.query("select first_name, last_name, date_of_birth, jmbag, number_of_ects from student",
                this::mapRowToStudent);

    }

    @Override
    public Optional<Student> findStudentByJMBAG(String jmbag) {
        return Optional.ofNullable(jdbc.queryForObject("select id, first_name, last_name, date_of_birth, jmbag, number_of_ects from student where jmbag = ?",
                this::mapRowToStudent, jmbag));
    }

    @Override
    public Optional<Student> save(Student student) {
        student.setDateOfBirth(LocalDate.of(1997, 2, 2));
        student.setId(saveStudentDetails(student));

        return Optional.ofNullable(student);
    }

    @Override
    public Optional<Student> update(String jmbag, Student student) {
        String updateQuery = "update student set FIRST_NAME = ?, LAST_NAME= ?, JMBAG = ?, NUMBER_OF_ECTS = ? where JMBAG = ?";
        jdbc.update(updateQuery, student.getFirstName(), student.getLastName(), student.getJmbag(), student.getNumberOfEcts(), jmbag);

        return Optional.ofNullable(student);
    }

    @Override
    public void delete(String jmbag) {
        String deleteQuery = "delete from student where jmbag = ?";
        jdbc.update(deleteQuery, jmbag);
    }

    public Long saveStudentDetails(Student student) {
        //student.setDateOfBirth(LocalDate.of(1997, 2, 2));

        Map<String, Object> values = new HashMap<>();
        values.put("first_name", student.getFirstName());
        values.put("last_name", student.getLastName());
        values.put("jmbag", student.getJmbag());
        values.put("date_of_birth", student.getDateOfBirth());
        values.put("number_of_ects", student.getNumberOfEcts());
        return studentInsert.executeAndReturnKey(values).longValue();
    }

    private Student mapRowToStudent(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setFirstName(rs.getString("first_name"));
        student.setLastName(rs.getString("last_name"));
        student.setJmbag(rs.getString("jmbag"));
        student.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());
        student.setNumberOfEcts(rs.getInt("number_of_ects"));
        return student;
    }
}
