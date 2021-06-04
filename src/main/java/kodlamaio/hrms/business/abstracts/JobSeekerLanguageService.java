package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerLanguage;

import java.util.List;


public interface JobSeekerLanguageService {
    DataResult<List<JobSeekerLanguage>> getAll();
    Result add(JobSeekerLanguage jobSeekerLanguage);
}
