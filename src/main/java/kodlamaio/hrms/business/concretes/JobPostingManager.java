package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingDao;
import kodlamaio.hrms.entities.concretes.JobPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostingManager implements JobPostingService {

    private JobPostingDao jobPostingDao;

    @Autowired
    public JobPostingManager(JobPostingDao jobPostingDao){
        super();
        this.jobPostingDao=jobPostingDao;
    }

    @Override
    public DataResult<List<JobPosting>> getAll() {
        return new SuccessDataResult<>
                (this.jobPostingDao.findAll(),"Data listed");
    }

    @Override
    public DataResult<List<JobPosting>> getAllSortedByApplicationDeadline() {
        Sort sort=Sort.by(Sort.Direction.DESC,"applicationDeadline");

        return new SuccessDataResult<>
                (this.jobPostingDao.findAll(sort));
    }

    @Override
    public Result add(JobPosting jobPosting) {
        this.jobPostingDao.save(jobPosting);
        return new SuccessResult("Added");
    }

    @Override
    public Result updateIsActiveByEmployerIdAndId(int employerId ,int id, boolean isActive) {
        JobPosting jobPosting=jobPostingDao.getByEmployer_IdAndId(employerId,id);
        jobPosting.setActive(isActive);
        jobPostingDao.save(jobPosting);
        return new SuccessResult("Updated");
    }

    @Override
    public DataResult<List<JobPosting>> getAllByisActive() {
        return new SuccessDataResult<>
                (this.jobPostingDao.getByisActive(true));
    }

    @Override
    public DataResult<JobPosting> getByEmployerIdAndId(int employerId,int id) {
        return new SuccessDataResult<>
                (this.jobPostingDao.getByEmployer_IdAndId(employerId,id));
    }

    @Override
    public DataResult<List<JobPosting>> getByisActiveAndCompanyName(String companyName) {
        return new SuccessDataResult<>
                (this.jobPostingDao.getByisActiveAndEmployer_companyName(true,companyName));
    }
}
