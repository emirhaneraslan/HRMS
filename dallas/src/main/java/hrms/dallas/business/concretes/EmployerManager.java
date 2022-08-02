package hrms.dallas.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.dallas.business.abstracts.EmployerService;
import hrms.dallas.core.utilities.results.DataResult;
import hrms.dallas.core.utilities.results.ErrorResult;
import hrms.dallas.core.utilities.results.Result;
import hrms.dallas.core.utilities.results.SuccessDataResult;
import hrms.dallas.core.utilities.results.SuccessResult;
import hrms.dallas.core.utilities.verifications.abstracts.EmailVerificationService;
import hrms.dallas.core.utilities.verifications.abstracts.HrmsApproveService;
import hrms.dallas.dataAccess.abstracts.EmployerDao;
import hrms.dallas.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private EmailVerificationService emailVerificationService;
	private HrmsApproveService hrmsApproveService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailVerificationService emailVerificationService,
			HrmsApproveService hrmsApproveService) {
		super();
		this.employerDao = employerDao;
		this.emailVerificationService=emailVerificationService;
		this.hrmsApproveService=hrmsApproveService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İş verenler listelendi.");
	}
	
	private Result isEmailExist (String email) {
		if (employerDao.findByEmail(email)!= null) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}

	@Override
	public Result add(Employer employer) {
		
		if (!this.isEmailExist(employer.getEmail()).isSuccess()) {
			return new ErrorResult("Email zaten mevcuttur.");
		}else if (!this.emailVerificationService.verifyEmail(employer.getEmail()).isSuccess()) {
			return new ErrorResult("Emailinizi kontrol ediniz lütfen.");
		}else if (!this.hrmsApproveService.isApprovedFromMe(employer).isSuccess()) {
			return new ErrorResult("İş veren HRMS personeli tarafından engellenmiştir.");
		}
		employerDao.save(employer);
		return new SuccessResult("İş veren başarıyla eklendi.");
	}

	

}
