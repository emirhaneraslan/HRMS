package hrms.dallas.core.utilities.verifications.concretes;

import org.springframework.stereotype.Service;

import hrms.dallas.core.utilities.results.Result;
import hrms.dallas.core.utilities.results.SuccessResult;
import hrms.dallas.core.utilities.verifications.abstracts.EmailVerificationService;

@Service
public class EmailVerificationManager implements EmailVerificationService{

	@Override
	public Result verifyEmail(String email) {
		return new SuccessResult();
	}

}
