package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;

import java.util.List;

public interface JobPostingService {
    DataResult<List<JobPosting>> getAll();
    DataResult<List<JobPosting>> getAll(int pageNo,int pageSize);
    DataResult<JobPosting> getById(int id);
    DataResult<List<JobPosting>> getAllSortedByApplicationDeadline();
    DataResult<List<JobPosting>> getAllByCity(String cityName);
    DataResult<List<JobPosting>> getAllByWorkTime(String workTime);
    DataResult<List<JobPosting>> getAllByWorkType(String workType);
    DataResult<List<JobPosting>> getAllByJob(String title);
    DataResult<List<JobPosting>> getAllByCityNameAndWorkTimeAndWorkType(String cityName,String workTime,String workType);
    Result add(JobPosting jobPosting);
    Result updateIsActive(int id,boolean isActive);
    DataResult<List<JobPosting>> getAllByActive(int pageNo,int pageSize);
    DataResult<List<JobPosting>> getAllByInActive(int pageNo,int pageSize);
    DataResult<List<JobPosting>> getByActiveAndCompanyName(String companyName);
}
