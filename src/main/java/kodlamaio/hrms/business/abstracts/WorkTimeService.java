package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.WorkTime;

import java.util.List;

public interface WorkTimeService {
    DataResult<List<WorkTime>> getAll();
}
