package kodlamaio.HRMSDB.entites.concretes;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name = "job_positions")
@NoArgsConstructor //(Boş constractr)
@AllArgsConstructor //dolu constractr
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class JobPosition {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name="created_date")
	private LocalDateTime createdDate = LocalDateTime.now();
	
	@Column(name="updated_date")
	private LocalDateTime updatedDate;
	
	@Column(name="status")
	private boolean status = true;
	
	@OneToMany(mappedBy = "jobPosition")
    private List<JobAdvertisement> jobAdvertisement;
	



	
	
	

    
	
	

}