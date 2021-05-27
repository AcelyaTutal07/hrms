package kodlamaio.HRMSDB.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMSDB.entites.concretes.ActivationCode;

public interface ActivationCodeDao extends JpaRepository<ActivationCode,Integer>{

	Optional<ActivationCode> findByUserId (int userId );
	
}
