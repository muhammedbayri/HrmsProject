package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobSeekerLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobSeekersLanguage")
public class JobSeekerLanguagesController {

    private final JobSeekerLanguageService jobSeekerLanguageService;

    @Autowired
    public JobSeekerLanguagesController(JobSeekerLanguageService jobSeekerLanguageService) {
        this.jobSeekerLanguageService = jobSeekerLanguageService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobSeekerLanguage>> getAll(){
        return this.jobSeekerLanguageService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobSeekerLanguage jobSeekerLanguage){
        return this.jobSeekerLanguageService.add(jobSeekerLanguage);
    }
}
