package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobPostingDao extends JpaRepository<JobPosting,Integer> {
    JobPosting getByEmployer_IdAndId(int employerId,int jobPostingId);
    List<JobPosting> getByisActive(boolean isActive);
    List<JobPosting> getByisActiveAndEmployer_companyName(boolean isActive,String companyName);
}
