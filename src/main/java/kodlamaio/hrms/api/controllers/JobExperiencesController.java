package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jopExperiences")
public class JobExperiencesController {

    private final JobExperienceService jobExperienceService;

    @Autowired
    public JobExperiencesController(JobExperienceService jobExperienceService) {
        this.jobExperienceService = jobExperienceService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobExperience>> getAll(){
        return this.jobExperienceService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobExperience jobExperience){
        return this.jobExperienceService.add(jobExperience);
    }

    @GetMapping("/getallBySorted")
    public DataResult<List<JobExperience>> getAllBySorted(){
        return this.jobExperienceService.getAllBySorted();
    }
}
