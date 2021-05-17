package kodlamaio.hrms.api.controller;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.entities.concretes.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobsConstroller {
    private JobService jobService;

    @Autowired
    public JobsConstroller(JobService jobService) {
        super();
        this.jobService = jobService;
    }

    @GetMapping("/getall")
    public List<Job> getAll(){
        return this.jobService.getAll();
    }
}
