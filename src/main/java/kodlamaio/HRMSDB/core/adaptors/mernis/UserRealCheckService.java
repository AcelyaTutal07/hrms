package kodlamaio.HRMSDB.core.adaptors.mernis;

import kodlamaio.HRMSDB.core.adaptors.model.MernisPerson;

public interface UserRealCheckService {
    boolean validate(MernisPerson person);

}
