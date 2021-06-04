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

    @ManyToOne()
    @JoinColumn(name = "social_media_id")
    private SocialMedia socialMedia;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private JobSeeker jobSeeker;

    @ManyToOne
    @JoinColumn(name = "candidate_image_id")
    private JobSeekerImage jobSeekerImage;

    @ManyToOne
    @JoinColumn(name = "candidate_technology_id")
    private JobSeekerTechnology jobSeekerTechnology;

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
