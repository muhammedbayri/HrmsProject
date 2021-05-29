package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;

import java.util.List;

public interface JobPostingService {
    DataResult<List<JobPosting>> getAll();
    DataResult<List<JobPosting>> getAllSortedByApplicationDeadline();
    Result add(JobPosting jobPosting);
    Result updateIsActiveByEmployerIdAndId(int employerId, int id,boolean isActive);
    DataResult<List<JobPosting>> getAllByisActive();
    DataResult<JobPosting> getByEmployerIdAndId(int employerId,int id);
    DataResult<List<JobPosting>> getByisActiveAndCompanyName(String companyName);
}
