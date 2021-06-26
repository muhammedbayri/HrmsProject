package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployerUpdate;

import java.util.List;

public interface EmployerUpdateService {
    DataResult<List<EmployerUpdate>> getAll();
    DataResult<EmployerUpdate> getById(int id);
    DataResult<EmployerUpdate> getByEmployerId(int id);
    Result add(EmployerUpdate employerUpdate);
    Result update(int id,String companyName,String website,String phone);
}
