package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingDao;
import kodlamaio.hrms.entities.concretes.JobPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostingManager implements JobPostingService {

    private final JobPostingDao jobPostingDao;

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
    public DataResult<List<JobPosting>> getAll(int pageNo,int pageSize) {
        Pageable pageable= PageRequest.of(pageNo-1,pageSize);
        return new SuccessDataResult<>
                (this.jobPostingDao.findAll(pageable).getContent());
    }

    @Override
    public DataResult<JobPosting> getById(int id) {
        return new SuccessDataResult<>
                (this.jobPostingDao.getById(id),"Data listed");
    }

    @Override
    public DataResult<List<JobPosting>> getAllSortedByApplicationDeadline() {
        Sort sort=Sort.by(Sort.Direction.DESC,"applicationDeadline");

        return new SuccessDataResult<>
                (this.jobPostingDao.findAll(sort));
    }

    @Override
    public DataResult<List<JobPosting>> getAllByCity(String cityName) {
        return new SuccessDataResult<>
                (this.jobPostingDao.getAllByCity_cityName(cityName));
    }

    @Override
    public DataResult<List<JobPosting>> getAllByWorkTime(String workTime) {
        return new SuccessDataResult<>
                (this.jobPostingDao.getAllByWorkTime_workTime(workTime));
    }

    @Override
    public DataResult<List<JobPosting>> getAllByWorkType(String workType) {
        return new SuccessDataResult<>
                (this.jobPostingDao.getAllByWorkType_workType(workType));
    }

    @Override
    public DataResult<List<JobPosting>> getAllByJob(String title) {
        return new SuccessDataResult<>
                (this.jobPostingDao.getAllByJob_title(title));
    }

    @Override
    public DataResult<List<JobPosting>> getAllByCityNameAndWorkTimeAndWorkType(String cityName, String workTime, String workType) {
        return new SuccessDataResult<>
                (this.jobPostingDao.getAllByCity_cityNameAndWorkTime_workTimeAndWorkType_workType(cityName,workTime,workType));
    }

    @Override
    public Result add(JobPosting jobPosting) {
        this.jobPostingDao.save(jobPosting);
        return new SuccessResult("Added");
    }

    @Override
    public Result updateIsActive(int id, boolean isActive) {
        JobPosting jobPosting=jobPostingDao.getById(id);
        jobPosting.setActive(isActive);
        jobPostingDao.save(jobPosting);
        return new SuccessResult("Updated");
    }

    @Override
    public DataResult<List<JobPosting>> getAllByActive(int pageNo,int pageSize) {
        Pageable pageable= PageRequest.of(pageNo-1,pageSize);
        return new SuccessDataResult<>
                (this.jobPostingDao.getByisActive(true,pageable).getContent(),
                        this.jobPostingDao.getByisActive(true,pageable).getTotalPages() + "");
    }
    

    @Override
    public DataResult<List<JobPosting>> getByActiveAndCompanyName(String companyName) {
        return new SuccessDataResult<>
                (this.jobPostingDao.getByisActiveAndEmployer_companyName(true,companyName));
    }

    @Override
    public DataResult<List<JobPosting>> getAllByInActive(int pageNo,int pageSize) {
        Pageable pageable= PageRequest.of(pageNo-1,pageSize);
        return new SuccessDataResult<>
                (this.jobPostingDao.getByisActive(false,pageable).getContent(),
                        this.jobPostingDao.getByisActive(false,pageable).getTotalPages() + "");
    }
}
