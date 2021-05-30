package kodlamaio.HRMSDB.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import kodlamaio.HRMSDB.business.abstracts.JobAdvertisementService;
import kodlamaio.HRMSDB.business.constraints.Messages;
import kodlamaio.HRMSDB.core.utilities.results.DataResult;
import kodlamaio.HRMSDB.core.utilities.results.Result;
import kodlamaio.HRMSDB.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMSDB.core.utilities.results.SuccessResult;
import kodlamaio.HRMSDB.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.HRMSDB.entites.concretes.JobAdvertisement;


@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
	
		List<JobAdvertisement> result = this.jobAdvertisementDao.findAll();
		return new SuccessDataResult<List<JobAdvertisement>>
		(result);
		
	
	}

	@Override
	public DataResult<List<JobAdvertisement>> findAllByIsActive() {
		List<JobAdvertisement> result = this.jobAdvertisementDao.findAllByIsActiveTrue();
		return new SuccessDataResult<List<JobAdvertisement>>
		(result, Messages.jobAdvertisementListed);
		
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByLastApplicationDate() {
		List<JobAdvertisement> result = this.jobAdvertisementDao.findAllByIsActiveOrderByLastApplicationDateDesc(true);
		return new SuccessDataResult<List<JobAdvertisement>>
		(result, Messages.jobAdvertisementListedByLastDate);
		
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByisActiveAndEmployerId(int id) {

		return new SuccessDataResult <List<JobAdvertisement>>(this.jobAdvertisementDao.getEmployersActiveJobAdvertisement(id),Messages.jobAdversitementListedByCompany);

	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll(int pageNo, int pageSize) {
      Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findAll(pageable).getContent());
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult();
	}

	@PutMapping()
	public Result update(int jobAdvertisementId,JobAdvertisement jobAdvertisemenet) {
		JobAdvertisement result = this.jobAdvertisementDao.findById(jobAdvertisementId).get();
		result.setActive(jobAdvertisemenet.isActive());
		if(jobAdvertisemenet.getLastApplicationDate().isBefore(LocalDate.now())) {
			result.isActive();
		}
		return new SuccessResult();
		
		
		
		
	}
}

