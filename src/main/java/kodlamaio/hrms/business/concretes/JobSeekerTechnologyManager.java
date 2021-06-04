package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobSeekerTechnologyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerTechnologyDao;
import kodlamaio.hrms.entities.concretes.JobSeekerTechnology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobSeekerTechnologyManager implements JobSeekerTechnologyService {

    private final JobSeekerTechnologyDao jobSeekerTechnologyDao;

    @Autowired
    public JobSeekerTechnologyManager(JobSeekerTechnologyDao jobSeekerTechnologyDao) {
        super();
        this.jobSeekerTechnologyDao = jobSeekerTechnologyDao;
    }

    @Override
    public DataResult<List<JobSeekerTechnology>> getAll() {
        return new SuccessDataResult<>
                (this.jobSeekerTechnologyDao.findAll(),"Data listed");
    }

    @Override
    public Result add(JobSeekerTechnology jobSeekerTechnology) {
        this.jobSeekerTechnologyDao.save(jobSeekerTechnology);
        return new SuccessResult("Added");
    }
}
