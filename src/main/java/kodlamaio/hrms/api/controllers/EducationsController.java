package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/educations")
@CrossOrigin
public class EducationsController {

    private final EducationService educationService;

    @Autowired
    public EducationsController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Education>> getAll(){
        return this.educationService.getAll();
    }

    @GetMapping("/getByCurriculaVitaeId")
    public DataResult<Education> getByCurriculaVitaeId(int curriculaVitaeId){
        return this.educationService.getByCurriculaVitaeId(curriculaVitaeId);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Education education){
        return this.educationService.add(education);
    }

    @PostMapping("/update")
    public Result add(@RequestParam int curriculaVitaeId, @RequestParam int schoolId, @RequestParam int schoolDepartmentId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate){
        return this.educationService.update(curriculaVitaeId,schoolId,schoolDepartmentId,startDate,endDate);
    }

    @GetMapping("/getallBySorted")
    public DataResult<List<Education>> getAllBySorted(){
        return this.educationService.getAllBySorted();
    }
}
