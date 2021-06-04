package kodlamaio.hrms.core.adapters.concretes;

import kodlamaio.hrms.core.adapters.abstracts.UserCheckService;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import org.springframework.stereotype.Service;

@Service
public class FakeMernisAdapter implements UserCheckService {
    @Override
    public boolean checkIsRealPerson(JobSeeker jobSeeker) {
        return jobSeeker.getNationalIdentity().length() == 11;
    }
}
