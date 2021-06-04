package kodlamaio.HRMSDB.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMSDB.entites.concretes.Workplace;

public interface WorkplaceDao extends JpaRepository<Workplace, Integer> {

}
