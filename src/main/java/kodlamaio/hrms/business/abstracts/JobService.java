package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Job;

import java.util.List;

public interface JobService {
    DataResult<List<Job>> getAll();
    Result add(Job job);
    DataResult<Job> getByTitle(String title);
}
