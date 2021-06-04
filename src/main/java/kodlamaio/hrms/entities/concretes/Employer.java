package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class Employer extends User{

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "web_address")
    private String website;

    @Column(name = "phone_number")
    private String phone;

    @JsonIgnore
    @OneToMany(mappedBy = "employer")
    private List<JobPosting> jobPostings;
}
