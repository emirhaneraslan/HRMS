package hrms.dallas.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.dallas.business.abstracts.JobPostingService;
import hrms.dallas.core.utilities.results.DataResult;
import hrms.dallas.core.utilities.results.Result;
import hrms.dallas.core.utilities.results.SuccessDataResult;
import hrms.dallas.core.utilities.results.SuccessResult;
import hrms.dallas.dataAccess.abstracts.CityDao;
import hrms.dallas.dataAccess.abstracts.EmployerDao;
import hrms.dallas.dataAccess.abstracts.JobPositionDao;
import hrms.dallas.dataAccess.abstracts.JobPostingDao;
import hrms.dallas.entities.concretes.JobPosting;
import hrms.dallas.entities.dtos.JobPostingDto;

@Service
public class JobPostingManager implements JobPostingService{

	private JobPostingDao jobPostingDao;
	private CityDao cityDao;
	private EmployerDao employerDao;
	private JobPositionDao jobPositionDao;

	
	
	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao, CityDao cityDao, EmployerDao employerDao, JobPositionDao jobPositionDao) {
		super();
		this.jobPostingDao = jobPostingDao;
		this.cityDao = cityDao;
		this.employerDao = employerDao;
		this.jobPositionDao=jobPositionDao;
}


	@Override
	public DataResult<List<JobPosting>> getAll() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll(),"İş ilanları listelendi");
	}


	@Override
	public Result add(JobPostingDto jobPostingDto) {
		
		JobPosting jobPosting = new JobPosting();
		
		jobPosting.setActive(jobPostingDto.isActive()?true:false);  //buna true parametresi geçilebilir ancak swagger kısmında false denemek için boş bıraktım. Bu sayede false atayabildim.
		jobPosting.setMinSalary(jobPostingDto.getMinSalary());
		jobPosting.setMaxSalary(jobPostingDto.getMaxSalary());
		jobPosting.setPositionDescription(jobPostingDto.getDescription());
		jobPosting.setActivePositionQuantity(jobPostingDto.getOpenPositions());
		jobPosting.setApplicationDeadline((jobPostingDto.getApplicationDeadline()));
		jobPosting.setCreationDate(jobPostingDto.getReleaseDateTime());
		//jobPosting.setEmployer(jobPostingDto.getEmployerId());
        
		jobPosting.setCity(this.cityDao.getByCityId(jobPostingDto.getCityId()));
		jobPosting.setCity(this.cityDao.getByCityName(jobPostingDto.getCityName()));
		jobPosting.setEmployer(this.employerDao.getById(jobPostingDto.getEmployerId())); //ileride yazılacak manipülasyonlar id üzerinde gerçekleşir.(update, delete gibi)
		jobPosting.setEmployer(this.employerDao.getByCompanyName(jobPostingDto.getCompanyName()));
		jobPosting.setJobPosition(this.jobPositionDao.getById(jobPostingDto.getCityId()));
		jobPosting.setJobPosition(this.jobPositionDao.getByTitleofjob(jobPostingDto.getTitleofjob()));
		
		
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult("İş ilanı eklendi.");
	}


	@Override
	public DataResult<List<JobPosting>> findAllActives() {
		return new SuccessDataResult<>(this.jobPostingDao.findAllByIsActiveTrue());
	}


	@Override
	public DataResult<List<JobPosting>> findAllCompanyNameAndIsActive(String companyName) {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAllByEmployer_CompanyNameAndIsActiveTrue(companyName),"İş ilanları listelendi.");
	}


	@Override
	public DataResult<List<JobPosting>> findAllByOrderByApplicationDeadlineAsc() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAllByOrderByApplicationDeadlineAsc(), " İş ilanları A'dan Z'ye sıralı şekilde sıralandı.");
	}
}
