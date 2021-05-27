package kodlamaio.HRMSDB.entites.dtos;

import java.sql.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterForCandidateDto extends AuthDto{
	
	private String firstName;
	private String lastName;
	private String nationalIdentity;
	private Date dateOfBirth;
	

}
