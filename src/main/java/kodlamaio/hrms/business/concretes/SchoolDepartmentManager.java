package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.SchoolDepartmentService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDepartmentDao;
import kodlamaio.hrms.entities.concretes.SchoolDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SchoolDepartmentManager implements SchoolDepartmentService {

    private final SchoolDepartmentDao schoolDepartmentDao;

    @Autowired
    public SchoolDepartmentManager(SchoolDepartmentDao schoolDepartmentDao) {
        this.schoolDepartmentDao = schoolDepartmentDao;
    }

    @Override
    public DataResult<List<SchoolDepartment>> getAll() {
        return new SuccessDataResult<>
                (this.schoolDepartmentDao.findAll(),"Data listed");
    }

    @Override
    public Result add(SchoolDepartment schoolDepartment) {
        this.schoolDepartmentDao.save(schoolDepartment);
        return new SuccessResult("Added");
    }
}
