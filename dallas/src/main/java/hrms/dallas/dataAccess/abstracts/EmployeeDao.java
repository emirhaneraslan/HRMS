package hrms.dallas.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.dallas.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee,Integer>{

	Employee findByIdentityNumber (String identityNumber);
	Employee findByEmail (String email);
	
}
