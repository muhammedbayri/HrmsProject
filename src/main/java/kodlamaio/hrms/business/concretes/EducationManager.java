package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDao;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDepartmentDao;
import kodlamaio.hrms.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class EducationManager implements EducationService {

    private final EducationDao educationDao;
    private final SchoolDao schoolDao;
    private final SchoolDepartmentDao schoolDepartmentDao;

    @Autowired
    public EducationManager(EducationDao educationDao, SchoolDao schoolDao, SchoolDepartmentDao schoolDepartmentDao) {
        this.educationDao = educationDao;
        this.schoolDao = schoolDao;
        this.schoolDepartmentDao = schoolDepartmentDao;
    }

    @Override
    public DataResult<List<Education>> getAll() {
        return new SuccessDataResult<>
                (this.educationDao.findAll(),"Data listed");
    }

    @Override
    public DataResult<Education> getByCurriculaVitaeId(int id) {
        return new SuccessDataResult<>
                (this.educationDao.getByCurriculaVitae_Id(id));
    }

    @Override
    public Result add(Education education) {
        this.educationDao.save(education);
        return new SuccessResult("Added");
    }

    @Override
    public Result update(int curriculaVitaeId, int schoolId, int schoolDepartmentId, LocalDate startDate, LocalDate endDate) {
        Education education=educationDao.getByCurriculaVitae_Id(curriculaVitaeId);
        education.setStartDate(startDate);
        education.setEndDate(endDate);
        education.setSchool(schoolDao.getById(schoolId));
        education.setSchoolDepartment(schoolDepartmentDao.getById(schoolDepartmentId));
        educationDao.save(education);
        return new SuccessResult("Updated Education");
    }

    @Override
    public DataResult<List<Education>> getAllBySorted() {
        Sort sort=Sort.by(Sort.Direction.ASC,"endDate");
        return new SuccessDataResult<>
                (this.educationDao.findAll(sort));
    }
}
