package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurriculaVitaeDto {

    private int id;

    private String coverLetter;

    private String FirstName;

    private String LastName;

    private String NationalIdentity;

    private String gitHub;

    private String linkedin;

    private String technology;

    private String imageUrl;

    private String companyName;

    private String schoolName;

    private String language;
}
