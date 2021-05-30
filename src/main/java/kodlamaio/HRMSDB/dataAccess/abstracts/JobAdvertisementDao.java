package kodlamaio.HRMSDB.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import kodlamaio.HRMSDB.entites.concretes.JobAdvertisement;

public interface JobAdvertisementDao  extends JpaRepository<JobAdvertisement, Integer>{

	List<JobAdvertisement> findAllByIsActiveTrue();
	
	List<JobAdvertisement> findAllByIsActiveOrderByLastApplicationDateDesc(boolean isActive);
	
	@Query("From JobAdvertisement where isActive = true and employer_id =:id")
	List<JobAdvertisement> getEmployersActiveJobAdvertisement(int id);

	
}
