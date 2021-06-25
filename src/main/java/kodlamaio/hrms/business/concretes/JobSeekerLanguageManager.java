package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobSeekerLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerLanguageDao;
import kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.hrms.entities.concretes.JobSeekerLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobSeekerLanguageManager implements JobSeekerLanguageService {

    private final JobSeekerLanguageDao jobSeekerLanguageDao;
    private final LanguageDao languageDao;

    @Autowired
    public JobSeekerLanguageManager(JobSeekerLanguageDao languageDao, LanguageDao languageDao1) {
        this.jobSeekerLanguageDao = languageDao;
        this.languageDao = languageDao1;
    }

    @Override
    public DataResult<List<JobSeekerLanguage>> getAll() {
        return new SuccessDataResult<>
                (this.jobSeekerLanguageDao.findAll(),"Data listed");
    }

    @Override
    public DataResult<JobSeekerLanguage> getByCurriculaVitaeId(int id) {
        return new SuccessDataResult<>
                (this.jobSeekerLanguageDao.getByCurriculaVitae_Id(id));
    }

    @Override
    public Result add(JobSeekerLanguage jobSeekerLanguage) {
        this.jobSeekerLanguageDao.save(jobSeekerLanguage);
        return new SuccessResult("Added");
    }

    @Override
    public Result update(int curriculaVitaeId, int languageDegree, int languageId) {
        JobSeekerLanguage jobSeekerLanguage=jobSeekerLanguageDao.getByCurriculaVitae_Id(curriculaVitaeId);
        jobSeekerLanguage.setLanguageDegree(languageDegree);
        jobSeekerLanguage.setLanguage(languageDao.getById(languageId));
        jobSeekerLanguageDao.save(jobSeekerLanguage);
        return new SuccessResult("Updated");
    }
}
