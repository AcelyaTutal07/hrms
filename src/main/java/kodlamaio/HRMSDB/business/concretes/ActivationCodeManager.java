package kodlamaio.HRMSDB.business.concretes;


import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMSDB.business.abstracts.ActivationCodeService;
import kodlamaio.HRMSDB.business.constraints.Messages;
import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMSDB.core.utilities.results.SuccessResult;
import kodlamaio.HRMSDB.dataAccess.abstracts.ActivationCodeDao;
import kodlamaio.HRMSDB.entites.concretes.ActivationCode;

@Service
public class ActivationCodeManager implements ActivationCodeService {

	private final ActivationCodeDao activationCodeDao;
	
	@Autowired
	public ActivationCodeManager(ActivationCodeDao activationCodeDao) {
		super();
		this.activationCodeDao = activationCodeDao;
	}

	//activationCode çalıştıktan 1gün sonra devre dışı kalsın.
	@Override
	public Result add(ActivationCode activationCode) {
		activationCode.setExpirationDate(LocalDateTime.now().plusMinutes(3));
		activationCodeDao.save(activationCode);
		return new SuccessResult(Messages.activationCodeAdded);	
	}
	

	@Override
	public Result update(ActivationCode activationCode) {
		activationCodeDao.save(activationCode);
		return new SuccessResult(Messages.activationCodeUpdated);
	}

	@Override
	public DataResult<Optional<ActivationCode>> getByUserId(int userId) {
		
		return new SuccessDataResult<Optional<ActivationCode>>(activationCodeDao.findByUserId(userId));
	}

	
}
