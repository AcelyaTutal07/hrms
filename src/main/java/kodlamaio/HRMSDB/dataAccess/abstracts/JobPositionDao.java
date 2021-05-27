package kodlamaio.HRMSDB.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.google.common.base.Optional;

import kodlamaio.HRMSDB.entites.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition,Integer>{

	 Optional<JobPosition> findByTitle(String title);
}
