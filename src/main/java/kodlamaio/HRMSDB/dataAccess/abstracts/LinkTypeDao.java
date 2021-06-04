package kodlamaio.HRMSDB.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMSDB.entites.concretes.LinkType;

public interface LinkTypeDao extends JpaRepository<LinkType, Integer> {

}
