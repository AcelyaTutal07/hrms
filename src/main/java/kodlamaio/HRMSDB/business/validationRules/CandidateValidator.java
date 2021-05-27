package kodlamaio.HRMSDB.business.validationRules;

import java.util.Date;

import org.springframework.stereotype.Component;

import kodlamaio.HRMSDB.business.constraints.Messages;
import kodlamaio.HRMSDB.core.utilities.results.ErrorResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.core.utilities.results.SuccessResult;
import kodlamaio.HRMSDB.entites.concretes.Candidate;

@Component
public class CandidateValidator extends UserValidator implements CandidateValidatorService{


	public Result candidateNullCheck(Candidate candidate) {
        String firstName = candidate.getFirstName();
        String lastName = candidate.getLastName();
        String tc = candidate.getNationalIdentity();
        Date birth = candidate.getDateOfBirth();


        if (!super.userNullCheck(candidate).isSuccess() || (firstName == null || firstName.isBlank()) ||
                (lastName == null || lastName.isBlank()) || (tc == null || tc.isBlank()) || birth == null) {
            return new ErrorResult(Messages.notNull);
        }
        return new SuccessResult();
    }

}
