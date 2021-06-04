package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CurriculaVitae;
import kodlamaio.hrms.entities.dtos.CurriculaVitaeDto;

import java.util.List;


public interface CurriculaVitaeService {
    DataResult<List<CurriculaVitae>> getAll();
    Result add(CurriculaVitae curriculaVitae);
    DataResult<List<CurriculaVitaeDto>> getAllByCv();
}
