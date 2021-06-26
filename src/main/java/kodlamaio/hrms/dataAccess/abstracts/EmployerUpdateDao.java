package kodlamaio.hrms.dataAccess.abstracts;


import kodlamaio.hrms.entities.concretes.EmployerUpdate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerUpdateDao extends JpaRepository<EmployerUpdate,Integer> {
    EmployerUpdate getById(int id);
    EmployerUpdate getByEmployerId(int employerId);
}
