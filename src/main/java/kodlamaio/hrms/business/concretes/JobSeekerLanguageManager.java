package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobSeekerLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerLanguageDao;
import kodlamaio.hrms.entities.concretes.JobSeekerLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobSeekerLanguageManager implements JobSeekerLanguageService {

    private final JobSeekerLanguageDao jobSeekerLanguageDao;

    @Autowired
    public JobSeekerLanguageManager(JobSeekerLanguageDao languageDao) {
        this.jobSeekerLanguageDao = languageDao;
    }

    @Override
    public DataResult<List<JobSeekerLanguage>> getAll() {
        return new SuccessDataResult<>
                (this.jobSeekerLanguageDao.findAll(),"Data listed");
    }

    @Override
    public Result add(JobSeekerLanguage jobSeekerLanguage) {
        this.jobSeekerLanguageDao.save(jobSeekerLanguage);
        return new SuccessResult("Added");
    }
}
