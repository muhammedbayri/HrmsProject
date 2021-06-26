package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployersController {
    private final EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService){
        this.employerService=employerService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Employer>> getAll(){
        return this.employerService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Employer> getById(int id){
        return this.employerService.getById(id);
    }

    @PostMapping ("/add")
    public Result add(@RequestBody Employer employer){

        return this.employerService.add(employer);
    }

    @PostMapping ("/update")
    public Result update(@RequestParam int id,@RequestParam String companyName,@RequestParam String website,@RequestParam String phone){
        return this.employerService.update(id,companyName,website,phone);
    }
}
