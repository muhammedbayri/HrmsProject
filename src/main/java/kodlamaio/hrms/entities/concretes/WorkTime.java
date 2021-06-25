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
@Table(name = "work_times")
public class WorkTime {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "work_time")
    private String workTime;

    @JsonIgnore
    @OneToMany(mappedBy = "workTime")
    private List<JobPosting> jobPostings;
}
