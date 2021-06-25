package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Education;

import java.time.LocalDate;
import java.util.List;


public interface EducationService {
    DataResult<List<Education>> getAll();
    DataResult<Education> getByCurriculaVitaeId(int curriculaVitaeId);
    Result add(Education education);
    Result update(int curriculaVitaeId, int schoolId, int schoolDepartmentId, LocalDate startDate,LocalDate endDate);
    DataResult<List<Education>> getAllBySorted();
}
