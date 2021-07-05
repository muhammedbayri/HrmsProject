package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_postings")
public class JobPosting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "number_of_open_position")
    private int numberOfOpenPosition;

    @Column(name = "application_deadline")
    private Date applicationDeadline;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "job_description")
    private String jobDescription;

    @Column(name = "salary_min")
    private double salaryMin;

    @Column(name = "salary_max")
    private double salaryMax;

    @ManyToOne
    @JoinColumn(name = "job_positions_id")
    private Job job;

    @ManyToOne
    @JoinColumn(name = "employers_id")
    private Employer employer;

    @ManyToOne
    @JoinColumn(name = "cities_id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "work_times_id")
    private WorkTime workTime;

    @ManyToOne
    @JoinColumn(name = "work_types_id")
    private WorkType workType;

    @JsonIgnore
    @OneToMany(mappedBy = "jobPosting")
    private List<FavoriteJobPosting> favoriteJobPostings;
}


