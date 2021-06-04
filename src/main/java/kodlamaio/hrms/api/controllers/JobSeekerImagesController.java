package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobSeekerImageService;
import kodlamaio.hrms.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/JobSeekerImages")
public class JobSeekerImagesController {

    private final JobSeekerImageService jobSeekerImageService;

    @Autowired
    public JobSeekerImagesController(JobSeekerImageService jobSeekerImageService) {
        super();
        this.jobSeekerImageService = jobSeekerImageService;
    }

    @PostMapping("/upload")
    public Result upload(@RequestParam MultipartFile jobSeekerImage){
        return this.jobSeekerImageService.upload(jobSeekerImage);
    }
}
