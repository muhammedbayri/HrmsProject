package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.FavoriteJobPosting;

import java.util.List;

public interface FavoriteJobPostingService {
    DataResult<List<FavoriteJobPosting>> getAll();
    DataResult<FavoriteJobPosting> getById(int id);
    DataResult<FavoriteJobPosting> getByJobPostingIdAndJobSeekerId(int jobPostingId,int jobSeekerId);
    DataResult<List<FavoriteJobPosting>> getAllByJobSeekerId(int jobSeekerId);
    Result add(FavoriteJobPosting favoriteJobPosting);
    Result delete(int id);
}
