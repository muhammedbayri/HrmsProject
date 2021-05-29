package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cities")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","JobAdvertisement"})
public class City {

    @Id
    @Column(name = "cities_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "city_name")
    private String cityName;

    @JsonIgnore
    @OneToMany(mappedBy = "city")
    private List<JobPosting> jobPostings;
}
