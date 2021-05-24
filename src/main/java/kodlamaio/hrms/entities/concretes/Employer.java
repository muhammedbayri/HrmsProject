package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
}
