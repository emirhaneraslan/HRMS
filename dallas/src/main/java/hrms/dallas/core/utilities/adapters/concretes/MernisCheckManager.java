package hrms.dallas.core.utilities.adapters.concretes;

import java.util.Locale;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.dallas.core.utilities.adapters.abstracts.MernisCheckService;
import hrms.dallas.core.utilities.results.ErrorResult;
import hrms.dallas.core.utilities.results.Result;
import hrms.dallas.core.utilities.results.SuccessResult;
import hrms.dallas.entities.concretes.Employee;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisCheckManager implements MernisCheckService{

	private KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
	
	/*@Autowired
	public MernisCheckManager(KPSPublicSoapProxy kpsPublicSoapProxy) {
		super();
		this.kpsPublicSoapProxy = kpsPublicSoapProxy;
	}
	*/

	@Override
	public Result checkIfRealPerson(Employee employee) throws Exception {

		
		boolean mernisResult = kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong(employee.getIdentityNumber()),
				employee.getName().toUpperCase(new Locale("tr","TR")),
				employee.getSurname().toUpperCase(new Locale("tr","TR")), employee.getYearOfBirth());
		
		if(!mernisResult) {
			return new ErrorResult("Bilgileriniz arasında uyuşmazlık vardır.");
		}
		return new SuccessResult("Bilgileriniz doğrudur.");
		/*
		boolean result = kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong(employee.getIdentityNumber()),
				employee.getName().toUpperCase(new Locale("tr","TR")),
				employee.getSurname().toUpperCase(new Locale("tr","TR")),
				Integer.parseInt(employee.getIdentityNumber()));
		
		if(!result) {
			return new ErrorResult();
		} 
		return new SuccessResult();
		*/
	}

}
