package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.business.concretes.FavoriteJobPostingManager;
import kodlamaio.hrms.entities.concretes.FavoriteJobPosting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteJobPostingDao extends JpaRepository<FavoriteJobPosting,Integer> {
    FavoriteJobPosting getById(int id);
    FavoriteJobPosting getByJobPostingIdAndJobSeekerId(int jobPostingId,int jobSeekerId);
    List<FavoriteJobPosting> getAllByJobSeeker_Id(int jobSeekerId);
}
