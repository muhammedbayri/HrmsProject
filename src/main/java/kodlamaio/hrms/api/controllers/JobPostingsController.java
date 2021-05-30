package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobPostings")
public class JobPostingsController {

    private final JobPostingService jobPostingService;

    @Autowired
    public JobPostingsController(JobPostingService jobPostingService) {
        super();
        this.jobPostingService = jobPostingService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobPosting>> getAll(){
        return this.jobPostingService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobPosting jobPosting){
        return this.jobPostingService.add(jobPosting);
    }

    @GetMapping("/getAllByisActive")
    DataResult<List<JobPosting>> getAllByisActive(){
        return this.jobPostingService.getAllByisActive();
    }

    @GetMapping("/getByisActiveAndCompanyName")
    DataResult<List<JobPosting>> getByisActiveAndCompanyName(@RequestParam String companyName){
        return this.jobPostingService.getByisActiveAndCompanyName(companyName);
    }

    @GetMapping("/getAllDesc")
    DataResult<List<JobPosting>> getAllSortedByApplicationDeadline(){
        return this.jobPostingService.getAllSortedByApplicationDeadline();
    }

    @PostMapping("/updateIsActiveById")
    public Result updateIsActiveById(@RequestParam int employerId,@RequestParam int id,@RequestParam boolean isActive){
        return this.jobPostingService.updateIsActiveByEmployerIdAndId(employerId,id,isActive);
    }
}
