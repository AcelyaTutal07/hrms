package kodlamaio.HRMSDB.entites.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="cv_details")
@AllArgsConstructor
@NoArgsConstructor
public class CvDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cv_detail_id")
	private int id;
	
	@OneToOne()
    @JoinColumn(name="candidate_id")
    private Candidate candidate;

    @Column(name="description")
    private String description;

    @Column(name="cv_photo_url")
    private String cvPhotoUrl;
	
}
