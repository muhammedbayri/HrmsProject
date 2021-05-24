package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Data
@Table(name = "candidates")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class JobSeeker extends User{

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "national_identity")
    private String nationalIdentity;

    @Column(name = "date_of_birth")
    private Date birthDate;
}
