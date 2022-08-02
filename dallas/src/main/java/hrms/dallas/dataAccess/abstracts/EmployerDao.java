package hrms.dallas.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.dallas.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer,Integer>{
	
	Employer findByEmail (String email);
	Employer getById(int id);
	Employer getByCompanyName(String companyName);

}
