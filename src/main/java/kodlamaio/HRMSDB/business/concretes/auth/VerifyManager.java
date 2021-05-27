package kodlamaio.HRMSDB.business.concretes.auth;


import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMSDB.business.abstracts.ActivationCodeService;
import kodlamaio.HRMSDB.business.abstracts.auth.VerifyService;
import kodlamaio.HRMSDB.business.constraints.Messages;
import kodlamaio.HRMSDB.core.utilities.results.ErrorResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.core.utilities.results.SuccessResult;
import kodlamaio.HRMSDB.entites.concretes.ActivationCode;

@Service
public class VerifyManager implements VerifyService {
	private ActivationCodeService activationCodeService;

    @Autowired
    public VerifyManager(ActivationCodeService activationCodeService) {
        this.activationCodeService = activationCodeService;
    }

    public Result verify(int userId, String activationCode) {
        Optional<ActivationCode> activation = activationCodeService.getByUserId(userId).getData();
        Result result = subVerify(activation,activationCode);
        if(!result.isSuccess()){
            return result;
        }
        activation.get().setActivationDate(LocalDateTime.now());
        activation.get().setIsConfirmed(true);
        activationCodeService.update(activation.get());
        
        return new SuccessResult(Messages.codeVerified);
    }

    private Result subVerify(Optional<ActivationCode> activation, String activationCode){
    	
    	if(!activation.isPresent()) {
			return new ErrorResult(Messages.activationNotFound);
		}
		if(activation.get().getIsConfirmed()) {
			return new ErrorResult(Messages.alreadyConfirmed);
		}
		if(activation.get().getExpirationDate().isBefore(LocalDateTime.now())) {//şimdiki zamanı  sonlandırma zamanını geçmişse
			return new ErrorResult(Messages.activationExpirated);
		}
		if(!activation.get().getActivationCode().equals(activationCode)) {
			return new ErrorResult(Messages.activationCodeNotEquals);
		}
	
           return new SuccessResult(Messages.activationConfirmed);
    }
}
	

