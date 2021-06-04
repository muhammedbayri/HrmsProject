package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.SocialMediaService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SocialMedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/socialMedias")
public class SocialMediasController {

    private final SocialMediaService socialMediaService;

    @Autowired
    public SocialMediasController(SocialMediaService socialMediaService) {
        this.socialMediaService = socialMediaService;
    }

    @GetMapping("/getall")
    private DataResult<List<SocialMedia>> getAll(){
        return this.socialMediaService.getAll();
    }

    @PostMapping("/add")
    private Result add(@RequestBody SocialMedia socialMedia){
        return this.socialMediaService.add(socialMedia);
    }
}
