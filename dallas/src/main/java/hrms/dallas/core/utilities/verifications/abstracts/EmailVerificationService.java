package hrms.dallas.core.utilities.verifications.abstracts;

import hrms.dallas.core.utilities.results.Result;

public interface EmailVerificationService {

	public Result verifyEmail (String email);
	
}
