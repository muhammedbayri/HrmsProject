package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "curricula_vitaes")
public class CurriculaVitae {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cover_letter")
    private String coverLetter;

    @Column(name = "github_link")
    private String githubLink;

    @Column(name = "linkedin_link")
    private String linkedinLink;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private JobSeeker jobSeeker;

    @JsonIgnore
    @OneToMany(mappedBy = "curriculaVitae")
    private List<JobSeekerImage> jobSeekerImages;

    @JsonIgnore
    @OneToMany(mappedBy = "curriculaVitae")
    private List<JobSeekerTechnology> jobSeekerTechnologies;

    @JsonIgnore
    @OneToMany(mappedBy = "curriculaVitae")
    private List<Education> educations;

    @JsonIgnore
    @OneToMany(mappedBy = "curriculaVitae")
    private List<JobExperience> jobExperiences;

    @JsonIgnore
    @OneToMany(mappedBy = "curriculaVitae")
    private List<JobSeekerLanguage> jobSeekerLanguages;

}
