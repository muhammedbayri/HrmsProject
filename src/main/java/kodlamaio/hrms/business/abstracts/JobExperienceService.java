package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobExperience;

import java.time.LocalDate;
import java.util.List;


public interface JobExperienceService {
    DataResult<List<JobExperience>> getAll();
    DataResult<JobExperience> getByCurriculaVitae(int id);
    Result add(JobExperience jobExperience);
    Result update(int curriculaVitaeId, String companyName, String positionName, LocalDate startDate,LocalDate endDate);
    DataResult<List<JobExperience>> getAllBySorted();
}
