package hr.tvz.prtenjaca.studapp.scheduler;

import hr.tvz.prtenjaca.studapp.dto.StudentDTO;
import hr.tvz.prtenjaca.studapp.services.StudentService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

public class SampleJob extends QuartzJobBean {

    @Autowired
    private StudentService studentService;
    private String name;

    public SampleJob() {
    }

    // Inject the "name" job data property
    public void setName(String name) {

    }


    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        List<StudentDTO> studentDTOList = studentService.findAll();
        System.out.println("Ovo su trenutno upisani sudenti");
        System.out.println("--------------------------------");
        for(StudentDTO s : studentDTOList){
            System.out.println(s.getJMBAG() + " - " + s.getFirstName() + " " + s.getLastName());
        }
        System.out.println("--------------------------------");

    }
}
