package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.SchoolDepartmentService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SchoolDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schoolDepartments")
public class SchoolDepartmentsController {

    private final SchoolDepartmentService schoolDepartmentService;

    @Autowired
    public SchoolDepartmentsController(SchoolDepartmentService schoolDepartmentService) {
        this.schoolDepartmentService = schoolDepartmentService;
    }

    @GetMapping("/getall")
    public DataResult<List<SchoolDepartment>> getAll(){
        return this.schoolDepartmentService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody SchoolDepartment schoolDepartment){
        return this.schoolDepartmentService.add(schoolDepartment);
    }
}
