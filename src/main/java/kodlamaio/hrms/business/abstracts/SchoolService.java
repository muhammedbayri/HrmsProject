package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.School;

import java.util.List;


public interface SchoolService {
    DataResult<List<School>> getAll();
    Result add(School school);
}
