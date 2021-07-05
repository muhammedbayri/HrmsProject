package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.FavoriteJobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.FavoriteJobPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favoriteJobPostings")
@CrossOrigin
public class FavoriteJobPostingsController {

    private final FavoriteJobPostingService favoriteJobPostingService;

    @Autowired
    public FavoriteJobPostingsController(FavoriteJobPostingService favoriteJobPostingService) {
        this.favoriteJobPostingService = favoriteJobPostingService;
    }

    @GetMapping("/getAll")
    public DataResult<List<FavoriteJobPosting>> getAll(){
        return this.favoriteJobPostingService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<FavoriteJobPosting> getById(@RequestParam int id){
        return this.favoriteJobPostingService.getById(id);
    }

    @GetMapping("/getByJobPostingIdAndJobSeekerId")
    public DataResult<FavoriteJobPosting> getByJobPostingIdAndJobSeekerId(@RequestParam int jobPostingId,@RequestParam int jobSeekerId){
        return this.favoriteJobPostingService.getByJobPostingIdAndJobSeekerId(jobPostingId,jobSeekerId);
    }

    @GetMapping("/getAllByJobSeekerId")
    public DataResult<List<FavoriteJobPosting>> getAllByJobSeekerId(@RequestParam int id){
        return this.favoriteJobPostingService.getAllByJobSeekerId(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody FavoriteJobPosting favoriteJobPosting){
        return this.favoriteJobPostingService.add(favoriteJobPosting);
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam int id){
        return this.favoriteJobPostingService.delete(id);
    }
}
