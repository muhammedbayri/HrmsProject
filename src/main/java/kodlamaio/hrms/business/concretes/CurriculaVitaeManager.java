package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CurriculaVitaeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CurriculaVitaeDao;
import kodlamaio.hrms.entities.concretes.CurriculaVitae;
import kodlamaio.hrms.entities.dtos.CurriculaVitaeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurriculaVitaeManager implements CurriculaVitaeService {

    private final CurriculaVitaeDao curriculaVitaeDao;

    @Autowired
    public CurriculaVitaeManager(CurriculaVitaeDao curriculaVitaeDao) {
        this.curriculaVitaeDao = curriculaVitaeDao;
    }

    @Override
    public DataResult<List<CurriculaVitae>> getAll() {
        return new SuccessDataResult<>
                (this.curriculaVitaeDao.findAll(),"Data listed");
    }

    @Override
    public Result add(CurriculaVitae curriculaVitae) {
        this.curriculaVitaeDao.save(curriculaVitae);
        return new SuccessResult("Added");
    }

    @Override
    public DataResult<List<CurriculaVitaeDto>> getAllByCv() {
        return new SuccessDataResult<>
                (this.curriculaVitaeDao.getAllByCv());
    }
}
