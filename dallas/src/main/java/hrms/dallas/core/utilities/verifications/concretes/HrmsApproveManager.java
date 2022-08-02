package hrms.dallas.core.utilities.verifications.concretes;

import org.springframework.stereotype.Service;

import hrms.dallas.core.utilities.results.Result;
import hrms.dallas.core.utilities.results.SuccessResult;
import hrms.dallas.core.utilities.verifications.abstracts.HrmsApproveService;
import hrms.dallas.entities.concretes.Employer;

@Service
public class HrmsApproveManager implements HrmsApproveService{

	@Override
	public Result isApprovedFromMe(Employer employer) {
		return new SuccessResult();
	}

}
