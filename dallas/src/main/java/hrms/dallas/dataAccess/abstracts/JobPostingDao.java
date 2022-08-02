package hrms.dallas.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import hrms.dallas.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {

	List<JobPosting> findAllByIsActiveTrue();
	
	List<JobPosting> findAllByEmployer_CompanyNameAndIsActiveTrue(@Param("companyName") String companyName);

	List<JobPosting> findAllByOrderByApplicationDeadlineAsc();
}
