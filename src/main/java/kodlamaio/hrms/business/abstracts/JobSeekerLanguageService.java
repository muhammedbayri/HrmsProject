package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerLanguage;

import java.util.List;


public interface JobSeekerLanguageService {
    DataResult<List<JobSeekerLanguage>> getAll();
    DataResult<JobSeekerLanguage> getByCurriculaVitaeId(int id);
    Result add(JobSeekerLanguage jobSeekerLanguage);
    Result update(int curriculaVitaeId,int languageDegree,int languageId);
}
