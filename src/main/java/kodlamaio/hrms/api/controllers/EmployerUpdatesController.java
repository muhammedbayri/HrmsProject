package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.EmployerUpdateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployerUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employerUpdates")
@CrossOrigin
public class EmployerUpdatesController {

    private final EmployerUpdateService employerUpdateService;

    @Autowired
    public EmployerUpdatesController(EmployerUpdateService employerUpdateService) {
        this.employerUpdateService = employerUpdateService;
    }

    @GetMapping("/getAll")
    public DataResult<List<EmployerUpdate>> getAll(){
        return this.employerUpdateService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<EmployerUpdate> getById(int id){
        return this.employerUpdateService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody EmployerUpdate employerUpdate){
        return this.employerUpdateService.add(employerUpdate);
    }

    @PostMapping("/update")
    public Result update(@RequestParam int id,@RequestParam String companyName,@RequestParam String website,@RequestParam String phone){
        return this.employerUpdateService.update(id,companyName,website,phone);
    }

    @PostMapping("/getByEmployerId")
    public DataResult<EmployerUpdate> getBuEmployerId(int id){
        return this.employerUpdateService.getByEmployerId(id);
    }
}
