package kodlamaio.HRMSDB.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMSDB.entites.concretes.Ability;

public interface AbilityDao extends JpaRepository<Ability, Integer> {
	

}
