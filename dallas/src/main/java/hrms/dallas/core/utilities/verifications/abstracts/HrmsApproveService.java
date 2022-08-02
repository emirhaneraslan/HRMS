package hrms.dallas.core.utilities.verifications.abstracts;

import hrms.dallas.core.utilities.results.Result;
import hrms.dallas.entities.concretes.Employer;

public interface HrmsApproveService {

	Result isApprovedFromMe (Employer employer);
}
