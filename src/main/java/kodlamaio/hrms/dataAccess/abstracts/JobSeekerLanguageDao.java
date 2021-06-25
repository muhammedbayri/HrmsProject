package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobSeekerLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerLanguageDao extends JpaRepository<JobSeekerLanguage,Integer> {
    JobSeekerLanguage getByCurriculaVitae_Id(int id);
}
