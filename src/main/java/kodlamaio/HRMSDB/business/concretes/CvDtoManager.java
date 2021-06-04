package kodlamaio.HRMSDB.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMSDB.business.abstracts.CandidateAbilityService;
import kodlamaio.HRMSDB.business.abstracts.CandidateLanguageService;
import kodlamaio.HRMSDB.business.abstracts.CandidateSchoolDepartmentService;
import kodlamaio.HRMSDB.business.abstracts.CandidateService;
import kodlamaio.HRMSDB.business.abstracts.CandidateWorkplacePositionService;
import kodlamaio.HRMSDB.business.abstracts.CvDtoService;
import kodlamaio.HRMSDB.business.abstracts.SocialMediaService;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.entites.dtos.CvDto;

@Service
public class CvDtoManager implements CvDtoService {

	private CandidateSchoolDepartmentService  candidateSchoolDepartmentService;
	private CandidateLanguageService canidateLanguageService;
	private CandidateAbilityService candidateAbilityService;
	private SocialMediaService socialMediaService;
	private CandidateService candidateService;
	private CandidateWorkplacePositionService candidateWorkplacePositionService;
	

	@Autowired
	public CvDtoManager(CandidateSchoolDepartmentService candidateSchoolDepartmentService,
			CandidateLanguageService canidateLanguageService, CandidateAbilityService candidateAbilityService,
			SocialMediaService socialMediaService, CandidateService candidateService,
			CandidateWorkplacePositionService candidateWorkplacePositionService) {
		
		this.candidateSchoolDepartmentService = candidateSchoolDepartmentService;
		this.canidateLanguageService = canidateLanguageService;
		this.candidateAbilityService = candidateAbilityService;
		this.socialMediaService = socialMediaService;
		this.candidateService = candidateService;
		this.candidateWorkplacePositionService = candidateWorkplacePositionService;
	}



	@Override
	public Result add(CvDto cvDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
