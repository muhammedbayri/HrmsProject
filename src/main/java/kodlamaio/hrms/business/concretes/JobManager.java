package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.JobDao;
import kodlamaio.hrms.entities.concretes.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobManager implements JobService {
    private JobDao jobDao;

    @Autowired
    public JobManager(JobDao jobDao){
        super();
        this.jobDao=jobDao;
    }

    @Override
    public DataResult<List<Job>> getAll() {
        return new SuccessDataResult<>
                (jobDao.findAll(),"Data Listelendi");
    }

    @Override
    public Result add(Job job) {
        if (getByTitle(job.getTitle()).getData()!=null){
            return new ErrorResult("Job position already exists");
        }
        else if ((job.getTitle().trim()).equals("")){
            return new ErrorResult("Null value cannot be defined");
        }
        this.jobDao.save(job);
        return new SuccessResult("Added");
    }

    @Override
    public DataResult<Job> getByTitle(String title) {
        return new SuccessDataResult<>
                (jobDao.findByTitle(title));
    }
}
