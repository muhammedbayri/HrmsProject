package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.WorkTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkTypeDao;
import kodlamaio.hrms.entities.concretes.WorkType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkTypeManager implements WorkTypeService {

    private final WorkTypeDao workTypeDao;

    public WorkTypeManager(WorkTypeDao workTypeDao) {
        super();
        this.workTypeDao = workTypeDao;
    }

    @Override
    public DataResult<List<WorkType>> getAll() {
        return new SuccessDataResult<>
                (this.workTypeDao.findAll(),"Data listed");
    }
}
