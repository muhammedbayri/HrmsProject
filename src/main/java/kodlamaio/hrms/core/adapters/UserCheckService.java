package kodlamaio.hrms.core.adapters;

import kodlamaio.hrms.entities.concretes.JobSeeker;
import org.springframework.stereotype.Service;


public interface UserCheckService {
    boolean checkIsRealPerson(JobSeeker jobSeeker);
}
