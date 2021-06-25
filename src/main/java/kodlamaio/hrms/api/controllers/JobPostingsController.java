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
@CrossOrigin
public class JobPostingsController {

    private final JobPostingService jobPostingService;

    @Autowired
    public JobPostingsController(JobPostingService jobPostingService) {
        super();
        this.jobPostingService = jobPostingService;
    }

    @GetMapping("/getAll")
    public DataResult<List<JobPosting>> getAll(){
        return this.jobPostingService.getAll();
    }

    @GetMapping("/getAllByPage")
    public DataResult<List<JobPosting>> getAll(@RequestParam int pageNo,@RequestParam(required = false,defaultValue = "10") int pageSize){
        return this.jobPostingService.getAll(pageNo,pageSize);
    }

    @GetMapping("/getById")
    public DataResult<JobPosting> getAllById(@RequestParam int id){
        return this.jobPostingService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobPosting jobPosting){
        return this.jobPostingService.add(jobPosting);
    }

    @GetMapping("/getAllByActive")
    DataResult<List<JobPosting>> getAllByActive(){
        return this.jobPostingService.getAllByActive();
    }

    @GetMapping("/getByActiveAndCompanyName")
    public DataResult<List<JobPosting>> getByActiveAndCompanyName(@RequestParam String companyName){
        return this.jobPostingService.getByActiveAndCompanyName(companyName);
    }

    @GetMapping("/getAllDesc")
    public DataResult<List<JobPosting>> getAllSortedByApplicationDeadline(){
        return this.jobPostingService.getAllSortedByApplicationDeadline();
    }

    @GetMapping("/getAllByCity")
    public DataResult<List<JobPosting>> getAllByCity(@RequestParam String cityName){
        return this.jobPostingService.getAllByCity(cityName);
    }

    @GetMapping("/getAllByWorkTime")
    public DataResult<List<JobPosting>> getAllByWorkTime(@RequestParam String workTime){
        return this.jobPostingService.getAllByWorkTime(workTime);
    }

    @GetMapping("/getAllByWorkType")
    public DataResult<List<JobPosting>> getAllByWorkType(@RequestParam String workType){
        return this.jobPostingService.getAllByWorkType(workType);
    }

    @GetMapping("/getAllByJob")
    public DataResult<List<JobPosting>> getAllByJob(@RequestParam String title){
        return this.jobPostingService.getAllByJob(title);
    }

    @GetMapping("/getAllByCityNameAndWorkTimeAndWorkType")
    public DataResult<List<JobPosting>> getAllByCityNameAndWorkTimeAndWorkType(@RequestParam(required = false) String cityName,@RequestParam(required = false) String workTime,@RequestParam(required = false) String workType) {
        return this.jobPostingService.getAllByCityNameAndWorkTimeAndWorkType(cityName,workTime,workType);
    }

    @PostMapping("/updateIsActive")
    public Result updateIsActiveById(@RequestParam int id,@RequestParam boolean isActive){
        return this.jobPostingService.updateIsActive(id,isActive);
    }

    @GetMapping("/getAllByInActive")
    public DataResult<List<JobPosting>> getAllByInActive(){
        return this.jobPostingService.getAllByInActive();
    }
}
