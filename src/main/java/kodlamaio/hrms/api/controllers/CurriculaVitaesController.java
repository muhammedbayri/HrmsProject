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
public class CurriculaVitaesController {

    private final CurriculaVitaeService curriculaVitaeService;

    @Autowired
    public CurriculaVitaesController(CurriculaVitaeService curriculaVitaeService) {
        this.curriculaVitaeService = curriculaVitaeService;
    }

    @GetMapping("/getall")
    public DataResult<List<CurriculaVitae>> getAll(){
        return this.curriculaVitaeService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody CurriculaVitae curriculaVitae){
        return this.curriculaVitaeService.add(curriculaVitae);
    }

    @GetMapping("/getallByCv")
    public DataResult<List<CurriculaVitaeDto>> getAllByCv(){
        return this.curriculaVitaeService.getAllByCv();
    }
}
