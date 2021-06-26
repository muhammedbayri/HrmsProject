package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerUpdateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerUpdateDao;
import kodlamaio.hrms.entities.concretes.EmployerUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerUpdateManager implements EmployerUpdateService {

    private final EmployerUpdateDao employerUpdateDao;

    @Autowired
    public EmployerUpdateManager(EmployerUpdateDao employerUpdateDao) {
        this.employerUpdateDao = employerUpdateDao;
    }

    @Override
    public DataResult<List<EmployerUpdate>> getAll() {
        return new SuccessDataResult<>
                (this.employerUpdateDao.findAll());
    }

    @Override
    public DataResult<EmployerUpdate> getById(int id) {
        return new SuccessDataResult<>
                (this.employerUpdateDao.getById(id));
    }

    @Override
    public DataResult<EmployerUpdate> getByEmployerId(int id) {
        return new SuccessDataResult<>
                (this.employerUpdateDao.getByEmployerId(id));
    }

    @Override
    public Result add(EmployerUpdate employerUpdate) {
        this.employerUpdateDao.save(employerUpdate);
        return new SuccessResult("Added");
    }

    @Override
    public Result update(int id, String companyName, String website, String phone) {
        EmployerUpdate employerUpdate=employerUpdateDao.getById(id);
        employerUpdate.setCompanyName(companyName);
        employerUpdate.setWebsite(website);
        employerUpdate.setPhone(phone);
        employerUpdateDao.save(employerUpdate);
        return new SuccessResult("Updated");
    }
}
