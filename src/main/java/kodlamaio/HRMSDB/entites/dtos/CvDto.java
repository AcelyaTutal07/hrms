package kodlamaio.HRMSDB.entites.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kodlamaio.HRMSDB.entites.concretes.Candidate;
import kodlamaio.HRMSDB.entites.concretes.CandidateAbility;
import kodlamaio.HRMSDB.entites.concretes.CandidateLanguage;
import kodlamaio.HRMSDB.entites.concretes.CandidateSchoolDepartment;
import kodlamaio.HRMSDB.entites.concretes.CandidateWorkplacePosition;
import kodlamaio.HRMSDB.entites.concretes.CvDetail;
import kodlamaio.HRMSDB.entites.concretes.SocialMedia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto{
	
	@JsonIgnore
	private Candidate candidate;
	
	private List<CandidateSchoolDepartment> CandidateSchoolDepartments;
	
	private List<CandidateWorkplacePosition> candidateWorkplacePosition;
	
	private List<CandidateLanguage> candidateLanguages;
	
	private List<CandidateAbility> candidateAbilities;
	
	private List<SocialMedia> socialMedias;
	
	private CvDetail cvDetail;
	
	

}
