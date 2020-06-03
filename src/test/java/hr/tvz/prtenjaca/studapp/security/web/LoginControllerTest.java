package hr.tvz.prtenjaca.studapp.security.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class LoginControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetLoggedUser() throws Exception {
        this.mockMvc
                .perform(get("/api/user").with(user("admin").password("test")
                        .roles("USER", "ADMIN")))
                .andExpect(status().isOk());
    }

//    @Test
//    void testAuthenticate() throws Exception {
//        this.mockMvc
//                .perform(post("/api/authenticate").with(user("admin").password("test")
//                        .roles("USER", "ADMIN")))
//                .andExpect(status().isOk());
//    }
}
