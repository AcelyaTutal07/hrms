package kodlamaio.HRMSDB.entites.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="candidate_schools_departments")
public class CandidateSchoolDepartment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="candidate_school_department_id")
	private int candidateSchoolDepartmentId;

	@Column(name="date_of_entry")
	private LocalDate dateOfEntry;
	
	@Column(name="date_of_qraduation")
	private LocalDate dateOfGraduation;
	
	@ManyToOne
	@JoinColumn(name="school_department_id")
	private SchoolDepartment schoolDepartment;
	
	@ManyToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
}
