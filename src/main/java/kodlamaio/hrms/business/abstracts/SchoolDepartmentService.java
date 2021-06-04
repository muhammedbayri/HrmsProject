package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SchoolDepartment;

import java.util.List;


public interface SchoolDepartmentService {
    DataResult<List<SchoolDepartment>> getAll();
    Result add(SchoolDepartment schoolDepartment);
}
