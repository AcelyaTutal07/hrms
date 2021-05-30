package kodlamaio.HRMSDB.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMSDB.entites.concretes.City;

public interface CityDao  extends JpaRepository<City, Integer> {
	

}
