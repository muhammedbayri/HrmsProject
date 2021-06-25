package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobPostingDao extends JpaRepository<JobPosting,Integer> {
    JobPosting getById(int id);
    List<JobPosting> getByisActive(boolean isActive);
    List<JobPosting> getAllByCity_cityName(String cityName);
    List<JobPosting> getAllByWorkTime_workTime(String workTime);
    List<JobPosting> getAllByWorkType_workType(String workType);
    List<JobPosting> getAllByJob_title(String title);
    List<JobPosting> getAllByCity_cityNameAndWorkTime_workTimeAndWorkType_workType(String cityName,String workTime,String workType);
    List<JobPosting> getByisActiveAndEmployer_companyName(boolean isActive,String companyName);
}
