package kodlamaio.HRMSDB.entites.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class AuthDto {
	
	private String password;
	private String confirmPassword;
	private String email;
	
	

}
