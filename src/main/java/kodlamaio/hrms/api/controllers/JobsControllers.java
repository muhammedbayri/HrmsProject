package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobsControllers {
    private JobService jobService;

    @Autowired
    public JobsControllers(JobService jobService) {
        super();
        this.jobService = jobService;
    }

    @GetMapping("/getall")
    public DataResult<List<Job>> getAll(){
        return this.jobService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Job job){
        return this.jobService.add(job);
    }
}
