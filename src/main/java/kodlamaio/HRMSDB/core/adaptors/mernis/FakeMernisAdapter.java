package kodlamaio.HRMSDB.core.adaptors.mernis;

import org.springframework.stereotype.Component;

import kodlamaio.HRMSDB.core.adaptors.model.MernisPerson;



@Component 
public class FakeMernisAdapter implements UserRealCheckService {

	

	@Override
	public boolean validate(MernisPerson person) {
		
		return true;
	}

}
