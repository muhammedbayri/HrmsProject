package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.SchoolDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolDepartmentDao extends JpaRepository<SchoolDepartment,Integer> {
}
