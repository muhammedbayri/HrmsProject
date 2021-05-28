package kodlamaio.hrms.core.adapters;

import kodlamaio.hrms.entities.concretes.JobSeeker;


public interface UserCheckService {
    boolean checkIsRealPerson(JobSeeker jobSeeker);
}
