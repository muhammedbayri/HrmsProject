package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CurriculaVitaeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CurriculaVitae;
import kodlamaio.hrms.entities.dtos.CurriculaVitaeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/curriculaVitaes")
@CrossOrigin
public class CurriculaVitaesController {

    private final CurriculaVitaeService curriculaVitaeService;

    @Autowired
    public CurriculaVitaesController(CurriculaVitaeService curriculaVitaeService) {
        this.curriculaVitaeService = curriculaVitaeService;
    }

    @GetMapping("/getAll")
    public DataResult<List<CurriculaVitae>> getAll(){
        return this.curriculaVitaeService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<CurriculaVitae> getById(@RequestParam int id){
        return this.curriculaVitaeService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody CurriculaVitae curriculaVitae){
        return this.curriculaVitaeService.add(curriculaVitae);
    }

    @PostMapping("/update")
    public Result update(@RequestParam int id,@RequestParam String coverLetter,@RequestParam String githubUsername,@RequestParam String linkedinUsername,@RequestParam String technologyName){
        return this.curriculaVitaeService.update(id,coverLetter,githubUsername,linkedinUsername,technologyName);
    }

    @GetMapping("/getAllDto")
    public DataResult<List<CurriculaVitaeDto>> getAllDto(){
        return this.curriculaVitaeService.getAllDto();
    }
}
