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
@Table(name = "candidate_technologies")
public class JobSeekerTechnology {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "technology_name")
    private String technologyName;

    @JsonIgnore
    @OneToMany(mappedBy = "jobSeekerTechnology")
    private List<CurriculaVitae> curriculaVitaes;
}
