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
@Table(name = "work_types")
public class WorkType {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "work_type")
    private String workType;

    @JsonIgnore
    @OneToMany(mappedBy = "workType")
    private List<JobPosting> jobPostings;
}
