package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.concretes.Job;

import java.util.List;

public interface JobService {
    List<Job> getAll();
}
