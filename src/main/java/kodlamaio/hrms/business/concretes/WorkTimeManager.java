package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.WorkTimeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkTimeDao;
import kodlamaio.hrms.entities.concretes.WorkTime;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkTimeManager implements WorkTimeService {

    private final WorkTimeDao workTimeDao;

    public WorkTimeManager(WorkTimeDao workTimeDao) {
        super();
        this.workTimeDao = workTimeDao;
    }

    @Override
    public DataResult<List<WorkTime>> getAll() {
        return new SuccessDataResult<>
                (this.workTimeDao.findAll(),"Data listed");
    }
}
