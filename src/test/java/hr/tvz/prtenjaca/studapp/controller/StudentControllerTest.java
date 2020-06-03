package hr.tvz.prtenjaca.studapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.tvz.prtenjaca.studapp.command.StudentCommand;
import hr.tvz.prtenjaca.studapp.domain.Student;
import hr.tvz.prtenjaca.studapp.dto.StudentDTO;
import hr.tvz.prtenjaca.studapp.services.StudentService;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.util.List;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private Validator validator;

    @Test
    void findAll() throws  Exception{
        this.mockMvc
                .perform(get("/student").with(user("admin").password("test")
                        .roles("USER", "ADMIN")))
                .andExpect(status().isOk());

    }

    @Test
    void getByJMBAG() throws  Exception{
        final String jmbag = "0246077242";

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/{jmbag}", jmbag)
                .with(user("admin")
                        .password("test")
                        .roles("ADMIN")
                ).with(csrf())
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isFound());
    }

    @Test
    void save() throws Exception{
        LocalDate date1 = LocalDate.of(2017, 1, 13);

        StudentCommand student = new StudentCommand("Marko", "Prtenjaca", "", 150);

        mockMvc.perform(MockMvcRequestBuilders.post("/student").with(user("admin")
                .password("test")
                .roles("ADMIN")
        ).with(csrf())
                .content(asJsonString(student))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn().getResolvedException().getMessage();
    }

    @Test
    void delete()throws  Exception{

        final String JMBAG = "0246077222";

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/student/{JMBAG}",JMBAG).
                with(user("admin")
                        .password("test")
                        .roles("ADMIN")
                ).with(csrf()))
                .andExpect(status().isNoContent());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
