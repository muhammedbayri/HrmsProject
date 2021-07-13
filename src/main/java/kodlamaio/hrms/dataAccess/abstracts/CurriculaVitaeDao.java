package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.CurriculaVitae;
import kodlamaio.hrms.entities.dtos.CurriculaVitaeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CurriculaVitaeDao extends JpaRepository<CurriculaVitae,Integer> {

    CurriculaVitae getById(int id);

    @Query("select new kodlamaio.hrms.entities.dtos.CurriculaVitaeDto" +
            "(cv.id,cv.coverLetter,js.firstName,js.lastName,js.nationalIdentity,cv.githubLink,cv.linkedinLink," +
            "tcn.technologyName ,ji.imageUrl ,je.companyName,edu.school.schoolName,jl.language.languageName)" +
            "from CurriculaVitae cv inner join cv.jobSeeker js inner join cv.educations edu inner join cv.jobExperiences je " +
            "inner join cv.jobSeekerLanguages jl inner join cv.jobSeekerImages ji " +
            "inner join cv.jobSeekerTechnologies tcn")
    List<CurriculaVitaeDto> getAllDto();
}
//cv.id,cv.coverLetter,js,sm,ji.imageUrl,je.companyName,edu.school.schoolName,jl.language