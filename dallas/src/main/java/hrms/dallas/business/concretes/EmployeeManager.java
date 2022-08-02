package hrms.dallas.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.dallas.business.abstracts.EmployeeService;
import hrms.dallas.core.utilities.adapters.abstracts.MernisCheckService;
import hrms.dallas.core.utilities.results.DataResult;
import hrms.dallas.core.utilities.results.ErrorResult;
import hrms.dallas.core.utilities.results.Result;
import hrms.dallas.core.utilities.results.SuccessDataResult;
import hrms.dallas.core.utilities.results.SuccessResult;
import hrms.dallas.core.utilities.verifications.abstracts.EmailVerificationService;
import hrms.dallas.dataAccess.abstracts.EmployeeDao;
import hrms.dallas.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService{

	private EmployeeDao employeeDao;
	private MernisCheckService mernisCheckService;
	private EmailVerificationService emailVerificationService;
	
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao,MernisCheckService mernisCheckService,
			EmailVerificationService emailVerificationService) {
		super();
		this.employeeDao = employeeDao;
		this.mernisCheckService=mernisCheckService;
		this.emailVerificationService=emailVerificationService;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(),"İşçiler listelendi.");
	}
	
	private Result isEmailExist (String email) {
		if (this.employeeDao.findByEmail(email) != null) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}
	
	private Result isIdentityNumberExist (String identityNumber) {
		if(this.employeeDao.findByIdentityNumber(identityNumber) != null) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}

	@Override
	public Result add(Employee employee) throws Exception{
	
		
		Result checkedPerson= mernisCheckService.checkIfRealPerson(employee);
		
		if (!checkedPerson.isSuccess()) {
		return new ErrorResult("Böyle bir kişi yoktur.");
	}else if (!this.isEmailExist(employee.getEmail()).isSuccess()){
		return new ErrorResult("Email zaten mevcuttur.");
	}else if (!this.isIdentityNumberExist(employee.getIdentityNumber()).isSuccess()) {
		return new ErrorResult("Tc Kimlik numarası zaten mevcuttur.");
	}else if (!this.emailVerificationService.verifyEmail(employee.getEmail()).isSuccess()) {
		return new ErrorResult("Emailinizi kontrol ediniz lütfen.");
	}
		
		
	
		
		
		
		
		this.employeeDao.save(employee);
		return new SuccessResult("İşçi Başarıyla Eklendi.");
	

	}
}