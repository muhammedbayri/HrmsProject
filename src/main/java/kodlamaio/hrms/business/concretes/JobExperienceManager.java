package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.hrms.entities.concretes.JobExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class JobExperienceManager implements JobExperienceService {

    private final JobExperienceDao jobExperienceDao;

    @Autowired
    public JobExperienceManager(JobExperienceDao jobExperienceDao) {
        this.jobExperienceDao = jobExperienceDao;
    }

    @Override
    public DataResult<List<JobExperience>> getAll() {
        return new SuccessDataResult<>
                (this.jobExperienceDao.findAll(),"Data listed");
    }

    @Override
    public DataResult<JobExperience> getByCurriculaVitae(int id) {
        return new SuccessDataResult<>
                (this.jobExperienceDao.getByCurriculaVitae_Id(id));
    }

    @Override
    public Result add(JobExperience jobExperience) {
        this.jobExperienceDao.save(jobExperience);
        return new SuccessResult("Added");
    }

    @Override
    public Result update(int curriculaVitaeId, String companyName, String positionName, LocalDate startDate, LocalDate endDate) {
        JobExperience jobExperience=jobExperienceDao.getByCurriculaVitae_Id(curriculaVitaeId);
        jobExperience.setCompanyName(companyName);
        jobExperience.setPositionName(positionName);
        jobExperience.setStartDate(startDate);
        jobExperience.setEndDate(endDate);
        jobExperienceDao.save(jobExperience);
        return new SuccessResult("Updated");
    }

    @Override
    public DataResult<List<JobExperience>> getAllBySorted() {
        Sort sort=Sort.by(Sort.Direction.ASC,"endDate");
        return new SuccessDataResult<>
                (this.jobExperienceDao.findAll(sort));
    }
}
