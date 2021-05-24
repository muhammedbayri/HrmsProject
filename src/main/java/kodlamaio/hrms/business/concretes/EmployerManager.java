package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.ConfirmationService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private ConfirmationService confirmationService;

    @Autowired
    public EmployerManager(EmployerDao employerDao,ConfirmationService confirmationService){
        this.employerDao=employerDao;
        this.confirmationService=confirmationService;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<>
                (this.employerDao.findAll(),"Data Listelendi");
    }

    @Override
    public Result add(Employer employer) {
        if(getByEmail(employer.getEmail()).getData()!=null){
            return new ErrorResult("Email already exist");
        }
        else if (!confirmationService.isConfirmed(employer)){
            return new ErrorResult("Email not verified");
        }
        this.employerDao.save(employer);
        return new SuccessResult("Eklendi");
    }

    @Override
    public DataResult<Employer> getByEmail(String email) {
        return new SuccessDataResult<>
                (employerDao.findByEmail(email));
    }
}
