package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "employer_updates")
@AllArgsConstructor
@NoArgsConstructor
public class EmployerUpdate {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "web_address")
    private String website;

    @Column(name = "phone_number")
    private String phone;

}
