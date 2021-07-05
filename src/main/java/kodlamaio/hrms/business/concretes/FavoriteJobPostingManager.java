package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.FavoriteJobPostingService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.FavoriteJobPostingDao;
import kodlamaio.hrms.entities.concretes.FavoriteJobPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteJobPostingManager implements FavoriteJobPostingService {

    private final FavoriteJobPostingDao favoriteJobPostingDao;

    @Autowired
    public FavoriteJobPostingManager(FavoriteJobPostingDao favoriteJobPostingDao) {
        this.favoriteJobPostingDao = favoriteJobPostingDao;
    }

    @Override
    public DataResult<List<FavoriteJobPosting>> getAll() {
        return new SuccessDataResult<>
                (this.favoriteJobPostingDao.findAll());
    }

    @Override
    public DataResult<FavoriteJobPosting> getById(int id) {
        return new SuccessDataResult<>
                (this.favoriteJobPostingDao.getById(id));
    }

    @Override
    public DataResult<FavoriteJobPosting> getByJobPostingIdAndJobSeekerId(int jobPostingId,int jobSeekerId) {
        return new SuccessDataResult<>
                (this.favoriteJobPostingDao.getByJobPostingIdAndJobSeekerId(jobPostingId,jobSeekerId));
    }

    @Override
    public DataResult<List<FavoriteJobPosting>> getAllByJobSeekerId(int jobSeekerId) {
        return new SuccessDataResult<>
                (this.favoriteJobPostingDao.getAllByJobSeeker_Id( jobSeekerId));
    }

    @Override
    public Result add(FavoriteJobPosting favoriteJobPosting) {
        if (getByJobPostingIdAndJobSeekerId(favoriteJobPosting.getJobPosting().getId(), favoriteJobPosting.getJobSeeker().getId()).getData()!=null){
            return new ErrorResult("Favorite already exist");
        }
        this.favoriteJobPostingDao.save(favoriteJobPosting);
        return new SuccessResult("Added");
    }

    @Override
    public Result delete(int id) {
        FavoriteJobPosting favoriteJobPosting=favoriteJobPostingDao.getById(id);
        this.favoriteJobPostingDao.delete(favoriteJobPosting);
        return new SuccessResult("Deleted");
    }
}
