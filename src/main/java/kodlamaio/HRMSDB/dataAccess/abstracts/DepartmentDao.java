package kodlamaio.HRMSDB.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMSDB.entites.concretes.Department;

public interface DepartmentDao extends JpaRepository<Department, Integer>{

}
