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
@Table(name = "social_medias")
public class SocialMedia {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "github_link")
    private String githubUsername;

    @Column(name = "linkedin_link")
    private String linkedinUsername;

    @JsonIgnore
    @OneToMany(mappedBy = "socialMedia")
    private List<CurriculaVitae> curriculaVitaes;
}
