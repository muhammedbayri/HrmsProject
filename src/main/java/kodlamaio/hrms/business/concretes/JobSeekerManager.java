package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.ConfirmationService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.adapters.UserCheckService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {
    private final JobSeekerDao jobSeekerDao;
    private final UserCheckService userCheckService;
    private final ConfirmationService confirmationService;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao,UserCheckService userCheckService, ConfirmationService confirmationService){
        this.jobSeekerDao=jobSeekerDao;
        this.userCheckService = userCheckService;
        this.confirmationService=confirmationService;
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<>(jobSeekerDao.findAll(),"Data listed");
    }

    @Override
    public Result add(JobSeeker jobSeeker) {
        if (!userCheckService.checkIsRealPerson(jobSeeker)){
            return new ErrorResult("not a valid person");
        }
        else if(getByNationalIdentity(jobSeeker.getNationalIdentity()).getData() != null){
            return new ErrorResult("National identity already exists");
        }
        else if (getByEmail(jobSeeker.getEmail()).getData() != null) {
            return new ErrorResult("Email already exists");
        }
        else if (!confirmationService.isConfirmed(jobSeeker)){
            return new ErrorResult("Email not verified");
        }
        this.jobSeekerDao.save(jobSeeker);
        return new SuccessResult("Added");
    }

    @Override
    public DataResult<JobSeeker> getByNationalIdentity(String nationalIdentity) {
        return new SuccessDataResult<>
                (jobSeekerDao.findByNationalIdentity(nationalIdentity));
    }

    @Override
    public DataResult<JobSeeker> getByEmail(String email) {
        return new SuccessDataResult<>
                (jobSeekerDao.findByEmail(email));
    }
}
