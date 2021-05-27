package kodlamaio.HRMSDB.entites.dtos;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterForEmployerDto extends AuthDto {

	private String companyName;
	private String webAdress;
	private String phoneNumber;
	
}
