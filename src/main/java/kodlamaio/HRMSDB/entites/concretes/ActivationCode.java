package kodlamaio.HRMSDB.entites.concretes;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "activation_code")
@NoArgsConstructor //(Boş constractr)
@AllArgsConstructor //dolu constractr

public class ActivationCode {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="activation_code")
	private String activationCode;
	
	@Column(name="is_confirmed")
	private Boolean isConfirmed = false;
	
	
	@Column(name="activation_date")
	private LocalDateTime activationDate;
	

	@Column(name="created_date")
	private LocalDateTime createdDate = LocalDateTime.now() ;
	
	
	@Column(name="updated_date")
	private LocalDateTime updatedDate;
	
	@Column(name="status")
	private Boolean status = true;
	
	@Column(name="expiration_date")
	private LocalDateTime expirationDate;
	

	public ActivationCode(int userId, String activationCode) {
		super();
		this.userId = userId;
		this.activationCode = activationCode;
	}
	
	
	

}
