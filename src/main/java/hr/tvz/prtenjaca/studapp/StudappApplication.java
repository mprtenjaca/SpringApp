package hr.tvz.prtenjaca.studapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StudappApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudappApplication.class, args);
    }

}
