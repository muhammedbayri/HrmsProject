package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {
    DataResult<List<Employer>> getAll();
    DataResult<Employer> getById(int id);
    Result add(Employer employer);
    Result update(int id,String companyName,String website,String phone);
    DataResult<Employer> getByEmail(String email);
}
