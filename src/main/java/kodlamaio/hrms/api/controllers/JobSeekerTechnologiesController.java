package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobSeekerTechnologyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerTechnology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/JobSeekerTechnologies")
public class JobSeekerTechnologiesController {

    private final JobSeekerTechnologyService jobSeekerTechnologyService;

    @Autowired
    public JobSeekerTechnologiesController(JobSeekerTechnologyService jobSeekerTechnologyService) {
        super();
        this.jobSeekerTechnologyService = jobSeekerTechnologyService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobSeekerTechnology>> getAll(){
        return this.jobSeekerTechnologyService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobSeekerTechnology jobSeekerTechnology){
        return this.jobSeekerTechnologyService.add(jobSeekerTechnology);
    }
}
